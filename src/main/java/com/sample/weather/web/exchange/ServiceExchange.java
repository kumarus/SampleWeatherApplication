package com.sample.weather.web.exchange;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sample.weather.web.config.OpenWeatherProperties;
import com.sample.weather.web.exception.CustomException;
import com.sample.weather.web.model.Weather;
import com.sample.weather.web.model.WeatherDetails;
import com.sample.weather.web.model.WeatherRespose;


/**
 * Service Exchange handles connectivity / get data from OpenWeather.
 * @author Srini
 *
 */
@Service
public class ServiceExchange {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExchange.class);
	
	/**
	 * Gets the weather detaills for given city.
	 * @param city
	 * @return
	 * @throws Exception
	 */

	public WeatherRespose getCityWeatherDetailsFromOpenWeather(String city) throws Exception {
		WeatherRespose weatherRespose = new WeatherRespose();

		try {
			String url = new OpenWeatherProperties().getOpenWeatherForecastURL(city);
			LOGGER.debug("URL :" + url);
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
				if (null != wsResponse.getSys().getSunrise()){										
					weatherRespose.setSunrise(dateFormat.format(java.util.Date.from(Instant.ofEpochSecond(wsResponse.getSys().getSunrise()))));
				}

				if (null != wsResponse.getSys().getSunset())
					weatherRespose.setSunset(dateFormat.format(java.util.Date.from(Instant.ofEpochSecond(wsResponse.getSys().getSunset()))));

			}
		} catch (HttpClientErrorException e) {
			LOGGER.debug("HttpClientErrorException Code: {} Message: {}", e.getStatusCode(), e.getMessage());
			throw new CustomException(e.getStatusCode().value(), e.getMessage());
		} catch (RestClientException e) {
			LOGGER.debug("RestClientException Code :" + e.getStackTrace());
		}
		return weatherRespose;
	}

}
