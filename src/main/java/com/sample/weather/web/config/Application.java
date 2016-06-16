package com.sample.weather.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This the start of the application which initializes the required properties
 * before get started.
 * 
 * @author Srini
 *
 */
@SpringBootApplication
@ComponentScan("com.sample.weather.web")
public class Application {

	public static void main(String[] args) {

		OpenWeatherProperties.appId = "a7e57603dd11cc32410b5764a1706625";
		SpringApplication.run(Application.class, args);
	}

}
