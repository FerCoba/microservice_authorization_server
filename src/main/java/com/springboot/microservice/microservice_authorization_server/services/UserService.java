package com.springboot.microservice.microservice_authorization_server.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.microservice.microservice_authorization_server.dto.RestTempateDto;
import com.springboot.microservice.microservice_authorization_server.security.SecurityConfiguration;

@Service
public class UserService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	SecurityConfiguration securityConfiguration;

	@Autowired
	RestTempateDto restTempateDto;

	@Override
	public UserDetails loadUserByUsername(@RequestBody String userName) throws UsernameNotFoundException {

		com.springboot.microservice.servicec_commons.model.entities.User user = restTempateDto
				.obtainInformationUserByUserName(userName).getUsers();

		if (user == null) {
			LOGGER.error("The user ".concat(userName).concat(" not exist."));
			throw new UsernameNotFoundException("The user ".concat(userName).concat(" not exist."));
		}

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());
		return new User(user.getUserName(), securityConfiguration.passwordEncoder().encode(user.getPassword()),
				user.getEnabled(), true, true, true, authorities);

	}

}
