package com.szopenak.SmartCave.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:/properties/secure.properties")
public class GeneralConfig {

}
