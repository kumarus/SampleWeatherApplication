package com.sample.weather.web.model;

import java.util.Date;

public class WeatherRespose {

	private String city;
	private Date todate;
	private String weatherDescription;
	private double temperatureInFahrenheit;
	private double temperatureInCelsius;
	private String sunrise;
	private String sunset;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getWeatherDescription() {
		return weatherDescription;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	public double getTemperatureInFahrenheit() {
		return temperatureInFahrenheit;
	}
	public void setTemperatureInFahrenheit(double temperatureInFahrenheit) {
		this.temperatureInFahrenheit = temperatureInFahrenheit;
	}
	public double getTemperatureInCelsius() {
		return temperatureInCelsius;
	}
	public void setTemperatureInCelsius(double temperatureInCelsius) {
		this.temperatureInCelsius = temperatureInCelsius;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	
}
