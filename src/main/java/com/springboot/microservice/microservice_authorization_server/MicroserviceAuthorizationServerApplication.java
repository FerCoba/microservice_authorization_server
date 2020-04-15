package com.springboot.microservice.microservice_authorization_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAuthorizationServerApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAuthorizationServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "Fer$C_C";
		
		for (int i = 0; i < 4; i++) {
			String passwordDbCrypt = passwordEncoder.encode(password);
			System.out.println(passwordDbCrypt);
		}
		
	}

}
