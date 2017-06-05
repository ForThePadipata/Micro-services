package com.github.origin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EcUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcUserServerApplication.class, args);
	}
}
