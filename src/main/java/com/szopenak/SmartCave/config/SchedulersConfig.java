package com.szopenak.SmartCave.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.szopenak.SmartCave.services.weather.WeatherService;

@Configuration
@EnableScheduling
public class SchedulersConfig {
	
	@Autowired
	WeatherService weatherService;

	@Scheduled(fixedRate = 10000)
	public void scheduleFixedRateTask() {
	    System.out.println(weatherService.getCurrentWeather());
	}
}
