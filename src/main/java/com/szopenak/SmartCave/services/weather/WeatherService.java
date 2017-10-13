package com.szopenak.SmartCave.services.weather;

import org.springframework.stereotype.Service;

import com.szopenak.SmartCave.domain.model.WeatherMeasure;


public interface WeatherService {
	
	public WeatherMeasure getCurrentWeather();

}
