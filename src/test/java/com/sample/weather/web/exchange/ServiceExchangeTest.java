package com.sample.weather.web.exchange;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sample.weather.web.config.OpenWeatherProperties;
import com.sample.weather.web.exception.CustomException;
import com.sample.weather.web.model.Weather;
import com.sample.weather.web.model.WeatherDetails;
import com.sample.weather.web.model.WeatherRespose;

public class ServiceExchangeTest {

	@Test
	public void testGetCityWeatherDetailsFromOpenWeather() throws Exception {
		String appId = "a7e57603dd11cc32410b5764a1706625";
		String city = "London";
		WeatherRespose weatherRespose = new WeatherRespose();		
		CustomException ce;

		try {
			OpenWeatherProperties openWeatherProperties = new OpenWeatherProperties();
			OpenWeatherProperties.appId = appId;
			String url = openWeatherProperties.getOpenWeatherForecastURL(city);		
			
			RestTemplate restTemplate = new RestTemplate();
			WeatherDetails wsResponse = restTemplate.getForObject(url, WeatherDetails.class);
			if (null != wsResponse) {
				weatherRespose.setCity(wsResponse.getName());
				weatherRespose.setTodate(java.util.Date.from(Instant.ofEpochSecond(wsResponse.getDt())));

				if (null != wsResponse.getWeather() && wsResponse.getWeather().size() > 0) {
					Weather weather = wsResponse.getWeather().stream().findFirst().get();
					weatherRespose.setWeatherDescription(weather.getDescription());
				}
				if (null != wsResponse.getMain().getTemp()) {
					double tempInFahrenheit = ((9 / 5) * wsResponse.getMain().getTemp()) - 459.67;
					weatherRespose.setTemperatureInFahrenheit(tempInFahrenheit);
				}
				if (null != wsResponse.getMain().getTemp()) {
					double tempInCelsius = wsResponse.getMain().getTemp() - 274;
					weatherRespose.setTemperatureInCelsius(tempInCelsius);
				}

				SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
				if (null != wsResponse.getSys().getSunrise())
					weatherRespose.setSunrise(dateFormat.format(new Date(wsResponse.getSys().getSunrise())));

				if (null != wsResponse.getSys().getSunset())
					weatherRespose.setSunset(dateFormat.format(new Date(wsResponse.getSys().getSunset())));	
			}
		} catch (HttpClientErrorException e) {
			 ce = new CustomException(e.getStatusCode().value(), e.getMessage());
			 
		} catch (RestClientException e) {
			throw e;
		}
		
		//assertEquals(ce.getCode(),401);
		assertEquals(weatherRespose.getCity(), city);
	}

}
