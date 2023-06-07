package com.ssafy.happyhouse.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//	Swagger-UI 2.x 확인
//	http://localhost:8080/{your-app-root}/swagger-ui.html
//	Swagger-UI 3.x 확인
//	http://localhost:8080/{your-app-root}/swagger-ui/index.html
	
	// swagger 주소
	// http://localhost:9999/swagger-ui/index.html

	private String version = "V1";
	private String title = "SSAFY final project " + version;
	
	// 유저 컨트롤러
	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName("유저").select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
					.paths(regex("/api/user.*")).build()
					.useDefaultResponseMessages(false);
	}
	
	// 보드 컨트롤러
	@Bean
	public Docket boardApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
				.apiInfo(apiInfo()).groupName("보드").select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
				.paths(regex("/api/board.*")).build()
				.useDefaultResponseMessages(false);
	}
	// 댓글 컨트롤러
		@Bean
		public Docket commentApi() {
			return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName("댓글").select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
					.paths(regex("/api/comment.*")).build()
					.useDefaultResponseMessages(false);
		}
		// 관심매물 컨트롤러
		@Bean
		public Docket bookmarkApi() {
			return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName("관심매물").select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
					.paths(regex("/api/bookmark.*")).build()
					.useDefaultResponseMessages(false);
		}
	
	// 동코드 컨트롤러
	@Bean
	public Docket dongCodeApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
				.apiInfo(apiInfo()).groupName("동코드").select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
				.paths(regex("/api/dongcode.*")).build()
				.useDefaultResponseMessages(false);
	}
	
	// 아파트 컨트롤러
	@Bean
	public Docket aptApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
				.apiInfo(apiInfo()).groupName("아파트").select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
				.paths(regex("/api/apt.*")).build()
				.useDefaultResponseMessages(false);
	}
	
	// 매물 컨트롤러
	@Bean
	public Docket propertyApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
				.apiInfo(apiInfo()).groupName("매물").select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
				.paths(regex("/api/property.*")).build()
				.useDefaultResponseMessages(false);
	}
	// 뉴스 컨트롤러
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
				.apiInfo(apiInfo()).groupName("뉴스").select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.model.controller"))
				.paths(regex("/api/news.*")).build()
				.useDefaultResponseMessages(false);
	}
	
	private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
//      consumes.add("application/xml;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title)
				.description("<h3>SSAFY API Reference for Developers</h3>Swagger를 이용한 API<br><img src=\"/assets/img/ssafy_logo.png\" width=\"150\">") 
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
				.license("SSAFY License")
				.licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp")
				.version("1.0").build();
	}
	
}
