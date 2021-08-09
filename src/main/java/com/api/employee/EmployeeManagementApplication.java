package com.api.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
//Causes Lombok to generate a logger field.
@Slf4j
//Main implementation class which serves two purposes in a spring boot application: Configuration and bootstrapping.
@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
		
		log.info("Server Started Successfully");
	}

}
