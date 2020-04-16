package com.springboot.microservice.microservice_authorization_server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSucessErrorHandler implements AuthenticationEventPublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSucessErrorHandler.class);

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails userDetailSuccess = (UserDetails) authentication.getPrincipal();
		LOGGER.info("User login ".concat(userDetailSuccess.getUsername()).concat(" success"));

	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		UserDetails userDetailFailure = (UserDetails) authentication.getPrincipal();
		LOGGER.error("Error in login user ".concat(userDetailFailure.getUsername()), exception.getMessage());

	}

}
