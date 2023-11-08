//package com.department.Configuration;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("com.department").select()
//                .apis( RequestHandlerSelectors.basePackage("com.department")).paths(regex("/department.*"))
//                .build();
//
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("department") // Replace with your actual project name
//                .description("API documentation for the Your Project Name") // Replace with a brief description of your project
//               .licenseUrl("safasfa")
//                .version("1.0") // Replace with your project version
//                .build();
//    }
//
//}