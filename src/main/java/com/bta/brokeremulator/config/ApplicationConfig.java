package com.bta.brokeremulator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ApplicationConfig {

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
