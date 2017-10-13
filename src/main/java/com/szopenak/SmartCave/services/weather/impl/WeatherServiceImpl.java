package com.szopenak.SmartCave.services.weather.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.szopenak.SmartCave.domain.model.WeatherMeasure;
import com.szopenak.SmartCave.services.weather.WeatherService;

import lombok.Data;

@Service
@Data
public class WeatherServiceImpl implements WeatherService {

	private static final String CITY_ID = "3093133";
	@Value("${weather.key}")
	private String API_ID;
	private static final String HOST_NAME = "api.openweathermap.org/data/2.5/weather";
	
	@Override
	public WeatherMeasure getCurrentWeather() {
		
		return new WeatherMeasure();
	}

}
