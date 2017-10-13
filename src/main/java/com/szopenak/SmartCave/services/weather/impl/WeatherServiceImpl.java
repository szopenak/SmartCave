package com.szopenak.SmartCave.services.weather.impl;



import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.szopenak.SmartCave.domain.model.WeatherMeasure;
import com.szopenak.SmartCave.services.weather.WeatherService;

import lombok.Data;


@Service
@Data
public class WeatherServiceImpl implements WeatherService {

	private static final String CITY_ID = "3093133";
	@Value("${weather.key}")
	private String API_ID;
	private static final String HOST_NAME = "http://api.openweathermap.org/data/2.5/weather";
	
	private ObjectMapper mapper = new ObjectMapper();
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public WeatherMeasure getCurrentWeather() {
		
		WeatherMeasure measure = new WeatherMeasure();
		RestTemplate restTemplate = new RestTemplate();
		String url = HOST_NAME+"?id="+CITY_ID+"&APPID="+API_ID;
		log.info(url);
		ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
		String json = response.getBody();
		try {
			JsonNode rootNode = mapper.readTree(json);
			JsonNode mainNode = rootNode.path("main");
			Float temperature = Float.parseFloat((mainNode.path("temp").asText()));
			measure.setTemperature(temperature.intValue() - 273);
			measure.setPressure(Integer.valueOf(mainNode.path("pressure").asText()));
			measure.setDate(LocalDateTime.now()); 
			JsonNode descNode = rootNode.path("weather");
			if (descNode.isArray()) {
				JsonNode node = descNode.iterator().next();
				measure.setMain(node.path("main").asText());
				measure.setDescription(node.path("description").asText());
			}
			
		} catch (JsonMappingException e) {
			log.error("Failed to consume rest!"); 
		} catch (IOException e) {
			log.error("IO exception during mapping"); 
		}
		
		return measure;
	}

}
