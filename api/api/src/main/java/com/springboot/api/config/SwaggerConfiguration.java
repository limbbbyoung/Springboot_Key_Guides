package com.springboot.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    /* Swagger 설정과 관련 설명
    Swagger 설정이 2.XX 버전의 지원 중단을 하면서
    pom.xml의 springfox-boot-starter 3.0.0 버전 패키지만 넣어주고
    따로 @EnableSwagger2를 명시해줄 필요가 없다.
    교재의 설명과 다르게 Swagger 설정을 해야한다.
    따라서 기존에 접속하던 UI 페이지였던 swagger-ui.html이 아니라
    /swagger-ui/index.html 페이지로 접속해야한다.
    * */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot Open API Test with Swagger")
                .description("설명 부분")
                .version("1.0.0")
                .build();
    }
}
