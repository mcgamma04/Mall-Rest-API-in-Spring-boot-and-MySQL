package com.stringcodeltd.productrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Mall API",version="1.0.0",description="Exploring Spring boot REST API"))
public class ProductrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductrestapiApplication.class, args);
	}

}
