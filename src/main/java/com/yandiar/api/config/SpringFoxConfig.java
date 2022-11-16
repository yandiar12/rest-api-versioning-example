package com.yandiar.api.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    private ArrayList<SecurityContext> securityContext() {
        SecurityReference securityReference = SecurityReference.builder()
                .reference("basicAuth")
                .scopes(new AuthorizationScope[0])
                .build();

        ArrayList<SecurityReference> reference = new ArrayList<>(1);
        reference.add(securityReference);

        ArrayList<SecurityContext> securityContexts = new ArrayList<>(1);
        securityContexts.add(SecurityContext.builder().securityReferences(reference).build());

        return securityContexts;
    }

    private ArrayList<SecurityScheme> securityScheme() {
        ArrayList<SecurityScheme> securityScheme = new ArrayList<>(1);
        securityScheme.add(new BasicAuth("basicAuth"));

        return securityScheme;
    }

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(securityScheme())
                .securityContexts(securityContext())
                .groupName("api-1.0")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.yandiar.api.controller"))
                .paths(PathSelectors.regex("/api/v1.*"))
                .build().apiInfo(apiInfo("1.0"));
    }

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(securityScheme())
                .securityContexts(securityContext())
                .groupName("api-2.0")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.yandiar.api.controller"))
                .paths(PathSelectors.regex("/api/v2.*"))
                .build().apiInfo(apiInfo("2.0"));
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder().title("REST API SPRING BOOT")
                .description("REST API SPRING BOOT")
                .termsOfServiceUrl("iconpln.co.id")
                .licenseUrl("iconpln.co.id")
                .contact(new Contact("Icon Plus", "", "aaa.bbb@iconpln.co.id"))
                .license("Icon+ License")
                .version(version)
                .build();
    }
}
