package com.teju.microservices.pathalogyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PathalogyServiceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathalogyServiceMsApplication.class, args);
	}

}
