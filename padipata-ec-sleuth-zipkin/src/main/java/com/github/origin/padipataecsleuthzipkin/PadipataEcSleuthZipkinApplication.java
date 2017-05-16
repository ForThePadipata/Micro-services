package com.github.origin.padipataecsleuthzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class PadipataEcSleuthZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadipataEcSleuthZipkinApplication.class, args);
	}
}
