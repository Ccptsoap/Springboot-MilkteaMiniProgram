package com.demo01.demo.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//这是注意的代码
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("milktea接口文档")
                .description("milktea相关接口的文档")
                .termsOfServiceUrl("https://www.charleschr.xyz")
                .version("1.0.0")
                .build();
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).
//                useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.regex("^(?!auth).*$"))
//                .build()
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
//                ;
//    }
//
//    private List<ApiKey> securitySchemes() {
//
//        return new ArrayList(
//                Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
//    }
//    private List<SecurityContext> securityContexts() {
//        return new ArrayList(
//                Collections.singleton(SecurityContext.builder()
//                        .securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                        .build())
//        );
//    }
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return new ArrayList(
//                Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
//    }


}
