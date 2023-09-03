package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UpAndRunningApplication {
	public static void main(String[] args) {
		SpringApplication.run(UpAndRunningApplication.class, args);
	}

}
