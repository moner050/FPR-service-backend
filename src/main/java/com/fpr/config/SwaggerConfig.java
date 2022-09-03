package com.fpr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.fpr.controller"})
public class SwaggerConfig {

    @Bean
    public Docket FprApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("금융상품 추천 API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fpr.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(FprApiInfo())
                .tags( new Tag("member-controller", "맴버정보 조회"))
                .tags( new Tag("auth-controller", "회원가입/로그인 토큰 재발급"))
                .tags( new Tag("saving-controller", "예금"))
                .tags( new Tag("deposit-controller", "적금"));
    }

    private ApiInfo FprApiInfo(){
        return new ApiInfoBuilder()
                .title("금융상품 추천 API")
                .description("금융상품 추천 API 목록")
                .version("1.0")
                .build();
    }
}
