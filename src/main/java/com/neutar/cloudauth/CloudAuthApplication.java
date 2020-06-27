package com.neutar.cloudauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class CloudAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudAuthApplication.class, args);
	}

}
