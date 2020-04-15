package com.springboot.microservice.microservice_authorization_server.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.springboot.microservice.microservice_authorization_server.dto.RestTempateDto;
import com.springboot.microservice.servicec_commons.model.entities.User;

@Component
public class InformationAdditionalToken implements TokenEnhancer {

	@Autowired
	RestTempateDto restTemplateDto;

	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> infoClient = new HashMap<>();
		
		User user = restTemplateDto
				.obtainInformationUserByUserName(authentication.getName()).getUsers();

		infoClient.put("userName", user.getFirstName());
		infoClient.put("lastName", user.getLastName());
		infoClient.put("email", user.getEmail());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(infoClient);

		return accessToken;
	}

}
