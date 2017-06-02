package com.github.origin.ecauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class EcAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcAuthServerApplication.class, args);
	}
}
