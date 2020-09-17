package com.gxy.sell.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GUO
 * @Classname SwaggerConfiger
 * @Description TODO
 * @Date 2020/7/11 15:59
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger2.enable}")
    private boolean enable;
    @Bean
    public Docket createDocket(){
        List<Parameter>parameterList=new ArrayList<>();
        ParameterBuilder parameterBuilder=new ParameterBuilder();
//        parameterBuilder.name("token").description("swagger调试(模拟传入用户凭证)").modelRef(new ModelRef("String"))
//                .parameterType("header").required(false);
        parameterBuilder.name("token").description("swagger调试(传入用户凭证)").modelRef(new ModelRef("String"))
                .parameterType("header").required(false);
        parameterList.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gxy.sell.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList)
                .enable(enable);
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("微信点餐系统的接口")
                .description("springboot 2.x")
                .version("1.0")
                .build();
    }
}
