package com.fpr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.fpr.controller"})
public class SwaggerConfig {

    @Bean
    public Docket FprApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(apiKey()))
                .groupName("금융상품 추천 API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fpr.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(FprApiInfo())
                .tags( new Tag("member-controller", "맴버정보 조회"))
                .tags( new Tag("auth-controller", "회원가입/로그인"))
                .tags( new Tag("product-controller", "예/적금 조회 및 검색"))
                .tags( new Tag("bookmark-controller", "즐겨찾기"))
                .tags( new Tag("cart-controller", "장바구니"))
                ;
    }

    private ApiInfo FprApiInfo(){
        return new ApiInfoBuilder()
                .title("금융상품 추천 API")
                .description("금융상품 추천 API 목록")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer +accessToken", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("Bearer +accessToken", authorizationScopes));
    }
}
