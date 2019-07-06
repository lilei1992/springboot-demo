package com.fsd.fsdredis.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * created by lilei
 * since 2019/7/6
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean
    @SuppressWarnings("all")
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("xx公司_xx项目_接口文档")
                        .description("redis测试文档")
                        .contact("lilei")
                        .version("1.0.0")
                        .build())

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fsd.fsdredis.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();


    }


}
