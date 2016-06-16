package com.sample.weather.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides the Open Weather Properties
 * @author Srini
 *
 */
public class OpenWeatherProperties {
	private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherProperties.class);
	public static String appId;
	private static String host = "http://api.openweathermap.org/data/2.5/weather";
	
	
	/**
	 * This method provides the URL to connect to the OpenWeather
	 * @param city
	 * @return
	 */

	public String getOpenWeatherForecastURL(String city) {
		LOGGER.info("Preparing URL.");
		return host + "?q=" + city + "&appid=" + appId;
	}

}
