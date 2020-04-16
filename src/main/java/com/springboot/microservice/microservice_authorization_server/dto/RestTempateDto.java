package com.springboot.microservice.microservice_authorization_server.dto;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.microservice.microservice_authorization_server.RestTemplateConfig;
import com.springboot.microservice.microservice_authorization_server.response.Response;

@Component
public class RestTempateDto {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestTempateDto.class);
	private static final String ENTRY_METHOD_MESSAGE = "entry in method {}.";
	private static final String GET_METHOD_MESSAGE = "get method {} {}.";

	@Autowired
	RestTemplateConfig restTemplateConfig;

	public Response obtainInformationUserByUserName(String userName) {

		LOGGER.info(ENTRY_METHOD_MESSAGE, "obtainInformationAllProducts");

		LOGGER.info(GET_METHOD_MESSAGE, "obtainInformationAllProducts", "for get info.");

		Map<String, String> parameters = new HashMap<>();
		parameters.put("userName", userName);
		Response userByUserName = restTemplateConfig.clientRestTemplate().getForObject(
				"http://192.168.99:8090/api/user/userName/{userName}/userInformationByUserName", Response.class, parameters);
		return userByUserName;
	}
}
