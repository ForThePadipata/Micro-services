package com.github.origin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EcComputeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcComputeServerApplication.class, args);
	}
}
