package com.tech1.personelmanagementsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SpringBootApplication
@EnableSwagger2WebMvc
public class PersonelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonelManagementSystemApplication.class, args);
	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tech1.personelmanagementsystem"))
				.paths(PathSelectors.any()).build();
	}



/*	@Bean
	public OpenAPI customOpenAPI(@Value("1.7.0") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("Your API Documentation").version("1.0.0"));
	}*/
	}
/*	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tech1.personelmanagementsystem"))
				.build();
	}*/



