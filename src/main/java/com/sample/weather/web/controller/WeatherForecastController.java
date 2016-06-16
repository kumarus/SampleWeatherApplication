package com.sample.weather.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.weather.web.exception.CustomException;
import com.sample.weather.web.exchange.ServiceExchange;
import com.sample.weather.web.model.WeatherRequest;
import com.sample.weather.web.model.WeatherRespose;

/**
 * This is the web controller which control the web requests.
 * @author Srini
 *
 */
@Controller
public class WeatherForecastController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForecastController.class);
	public static String appid;

	
	/**
	 * Handles to display Weather request form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String weatherRequestForm(Model model) {
		model.addAttribute("weatherrequest", new WeatherRequest());
		return "weatherrequestpage";
	}
	
	/**
	 * Gets the weather forecast data from the OpenWeather and send it to UI
	 * @param weatherrequest
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	@ExceptionHandler(CustomException.class)
	public String weatherRequestSubmit(@ModelAttribute WeatherRequest weatherrequest, Model model) throws Exception {

		if (null == weatherrequest.getCity()) {
			LOGGER.info("Invalid City Name entered.");
			throw new CustomException(0, "Invalid input");
		}

		WeatherRespose weatherResponse = new ServiceExchange()
				.getCityWeatherDetailsFromOpenWeather(weatherrequest.getCity());
		model.addAttribute("weatherresponse", weatherResponse);

		return "weatherdetailspage";
	}
	
	/**
	 * Handles all the Exceptions
	 * @param model
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(Exception.class)
	public String handleAllException(Model model, Exception ex) {
		model.addAttribute("exceptionmessage", "Ooops....Some thing went wrong.....");
		return "errorpage";

	}

}
