package com.heavensentlocator.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.heavensentlocator.backend.data.User;
import com.heavensentlocator.backend.data.UserControl;

//Run This File To Start Up The Spring Boot Application
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BackendApplication {

	public static void main(String[] args) {
		UserControl.init();
		SpringApplication.run(BackendApplication.class, args);
	
	}

}
