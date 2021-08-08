package com.consumerback.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

//	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiInfo metaInfo() {
		
		return new ApiInfo(
				"PayWell Consumer App Backend", 
				"PayWell Consumer App Backend Application....", 
				"0.0.2", 
				"Terms and Condition", 
				new Contact("Md. Faiz Shiraji", "https://www.linkedin.com/in/md-faiz-shiraji-1b2075206", "faiz.shiraji@cloudwell.co"), 
				"CloudWell Limited", 
				"https://www.paywellonline.com"
				);
	}
	
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.consumerback"))
////				.paths(regex("/user.*"))
//				.build().apiInfo(metaInfo());
//	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metaInfo()).securityContexts(Arrays.asList(securityContext()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

//	private ApiKey apiKey() {
//		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	}
	
	private SecurityContext	securityContext() {
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.build();
		
	}
	
	List<SecurityReference> defaultAuth(){
		AuthorizationScope authorizationScope 
		= new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
		
	}
	
}
