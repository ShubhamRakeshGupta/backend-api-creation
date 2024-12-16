package com.example.cruddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	/*
	 * public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select()
	 * .apis(RequestHandlerSelectors.basePackage("com.example.cruddemo.controller"))
	 * .paths(PathSelectors.any()) .build() .apiInfo(apiInfo()); }
	 */
	public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CrudDemo")
                        .description("API documentation for CRUD operations in Spring Boot")
                        .version("v1.0"));
    }
	/*
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder()
	 * .title("Spring Boot CRUD API Documentation")
	 * .description("API documentation for CRUD operations in Spring Boot")
	 * .version("1.0") .build(); }
	 */
	
}
