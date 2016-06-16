package com.sample.weather.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
	
	private Double temp;
	private Integer pressure;
	private Integer humidity;
	private Double temp_min;
	private Double temp_max;
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}

	

}
