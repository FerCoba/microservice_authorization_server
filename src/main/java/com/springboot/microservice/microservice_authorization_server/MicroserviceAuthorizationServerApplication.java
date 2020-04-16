package com.springboot.microservice.microservice_authorization_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAuthorizationServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAuthorizationServerApplication.class, args);
	}

}
