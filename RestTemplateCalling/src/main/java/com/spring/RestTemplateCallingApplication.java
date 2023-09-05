package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

@EnableWebSecurity
@SpringBootApplication
public class RestTemplateCallingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateCallingApplication.class, args);
	}

	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();

	
}
}