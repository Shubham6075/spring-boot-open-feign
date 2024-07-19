package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootOpenFeignClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOpenFeignClient2Application.class, args);
	}

}
