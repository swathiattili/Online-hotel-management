package com.microservice.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class GuestServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(GuestServiceApplication.class, args);
	}

}
