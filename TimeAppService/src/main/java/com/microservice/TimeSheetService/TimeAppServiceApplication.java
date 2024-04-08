package com.microservice.TimeSheetService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservice.TimeSheetService")
public class TimeAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeAppServiceApplication.class, args);
	}

}
