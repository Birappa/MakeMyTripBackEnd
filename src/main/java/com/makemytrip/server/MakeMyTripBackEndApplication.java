package com.makemytrip.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class MakeMyTripBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeMyTripBackEndApplication.class, args);
	}

}

