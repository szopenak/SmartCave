package com.szopenak.SmartCave.domain.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

public class WeatherMeasure {

	private String main;
	private String description;
	private Integer temperature;
	private Integer pressure;
	private LocalDateTime date;
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "WeatherMeasure [main=" + main + ", description=" + description + ", temperature=" + temperature
				+ ", pressure=" + pressure + ", date=" + date + "]";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTemperature() {
		return temperature;
	}
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
