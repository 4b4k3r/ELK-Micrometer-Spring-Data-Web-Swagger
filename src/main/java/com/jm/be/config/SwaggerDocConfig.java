package com.jm.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Optional;

@Configuration
public class SwaggerDocConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Item Crud")
                .description("This is item crud api")
                .license("No Licensed - 1.0")
                .licenseUrl("http://www.some-domain.com/licenses/LICENSE-1.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0.0")
                .contact(new Contact("","", "user@domain.com"))
                .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jm.be.controller"))
                .build()
                .genericModelSubstitutes(Optional.class)
                .apiInfo(apiInfo());
    }
}
