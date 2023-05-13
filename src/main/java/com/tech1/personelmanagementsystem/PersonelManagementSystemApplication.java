package com.tech1.personelmanagementsystem;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;




//@EnableSwagger2
@SpringBootApplication
@EnableWebMvc
public class PersonelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonelManagementSystemApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("1.7.0") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("Your API Documentation").version("1.0.0"));
	}
	}
/*	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tech1.personelmanagementsystem"))
				.build();
	}*/



