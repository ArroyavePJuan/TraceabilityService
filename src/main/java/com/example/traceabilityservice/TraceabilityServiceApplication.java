package com.example.traceabilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TraceabilityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraceabilityServiceApplication.class, args);
	}

}
