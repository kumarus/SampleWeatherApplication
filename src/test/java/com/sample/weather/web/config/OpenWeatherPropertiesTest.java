package com.sample.weather.web.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OpenWeatherPropertiesTest {
	public static String appId = "a7e57603dd11cc32410b5764a1706625";
	private static String host = "http://api.openweathermap.org/data/2.5/weather";

	/**
	 * This method test the URL construction.
	 */
	@Test
	public void testGetOpenWeatherForecastURL() {
		String city = "london";
		OpenWeatherProperties openWeatherProperties = new OpenWeatherProperties();
		OpenWeatherProperties.appId = appId;
		String url = openWeatherProperties.getOpenWeatherForecastURL(city);
		String actualUrl = host + "?q=" + city + "&appid=" + appId;		
		assertEquals(actualUrl, url);
	}

}
