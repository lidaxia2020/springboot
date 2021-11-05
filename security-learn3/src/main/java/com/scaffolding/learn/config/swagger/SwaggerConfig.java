package com.scaffolding.learn.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 23:08
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig {
    @Autowired
    private SwaggerProperties swaggerProperties;
    @Bean
    public Docket api() {
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        parameterBuilder.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        if(swaggerProperties.getTitle()!=null){
            apiInfoBuilder.title(swaggerProperties.getTitle());
        }
        if(swaggerProperties.getContractName()!=null&&swaggerProperties.getContractUrl()!=null&&
                swaggerProperties.getContractEmail()!=null){
            apiInfoBuilder.contact(new Contact(swaggerProperties.getContractName(), swaggerProperties.getContractUrl(),
                    swaggerProperties.getContractEmail()));
        }
        if(swaggerProperties.getVersion()!=null){
            apiInfoBuilder.version(swaggerProperties.getVersion());
        }
        return apiInfoBuilder.build();
    }
}