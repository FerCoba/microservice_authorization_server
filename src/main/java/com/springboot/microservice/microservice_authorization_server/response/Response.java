package com.springboot.microservice.microservice_authorization_server.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.microservice.servicec_commons.model.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	private String status;
	private String message;
	private User users;
	private List<User> usersList;
}
