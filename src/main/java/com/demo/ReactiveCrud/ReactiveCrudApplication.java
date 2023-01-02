package com.demo.ReactiveCrud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(
		title="Reactive Crud Example APP",
		version= "1.0",
		description="Swagger Implementation"
))

public class ReactiveCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCrudApplication.class, args);
	}

}

