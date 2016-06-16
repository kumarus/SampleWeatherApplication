package com.sample.weather.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails {

	private String name;
	private Integer dt;
	private List<Weather> weather;
	private Sys sys;
	private Main main;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDt() {
		return dt;
	}
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	@Override
	public String toString() {
		return "WeatherDetails [name=" + name + ", dt=" + dt + ", weather=" + weather + ", sys=" + sys + ", main="
				+ main + "]";
	}
	
	
}
