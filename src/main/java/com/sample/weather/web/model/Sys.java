package com.sample.weather.web.model;

public class Sys {
	
	private Integer sunrise;
	private Integer sunset;
	private String country;
	public Integer getSunrise() {
		return sunrise;
	}
	public void setSunrise(Integer sunrise) {
		this.sunrise = sunrise;
	}
	public Integer getSunset() {
		return sunset;
	}
	public void setSunset(Integer sunset) {
		this.sunset = sunset;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Sys [sunrise=" + sunrise + ", sunset=" + sunset + ", country=" + country + "]";
	}
	
	
}
