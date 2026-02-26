package com.pie.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBankProject {

	public static void main(String[] args) {
		SpringApplication.run(SpringBankProject.class, args);
		System.out.println("Welcome to spring boot rest api project");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
