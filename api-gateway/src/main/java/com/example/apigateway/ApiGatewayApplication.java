package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

import com.netflix.discovery.shared.Application;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		new SpringApplicationBuilder(Application.class)
	    .web(WebApplicationType.SERVLET)
	    .run(args);
	}
	
	  @Bean public ServerCodecConfigurer serverCodecConfigurer() { return
	  ServerCodecConfigurer.create(); }
	 
}
