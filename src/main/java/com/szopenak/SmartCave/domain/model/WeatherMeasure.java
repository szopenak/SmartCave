package com.szopenak.SmartCave.domain.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherMeasure {

	private String main;
	private String description;
	private Integer temperature;
	private Integer pressure;
	private LocalDateTime date;
}
