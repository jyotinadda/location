package com.example.ShriTailors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class ShriTailorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShriTailorsApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example.ShriTailors"))
				.build()
				.apiInfo(apiDetails());
				
	}
	
	private ApiInfo apiDetails()
	{
		List<VendorExtension> vendorExtensions = new ArrayList<>();
		return new ApiInfo(
				"Shri Tailor API",
				"Sample api for shri tailors",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Jyoti Nadda", "http://jyoti.io", "jyotinadda@gmail.com"),
				"API License",
				"http:javabrains.io",
				vendorExtensions);
			
	}
}
