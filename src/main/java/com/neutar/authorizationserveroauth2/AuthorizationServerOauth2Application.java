package com.neutar.authorizationserveroauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AuthorizationServerOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerOauth2Application.class, args);
	}

}
