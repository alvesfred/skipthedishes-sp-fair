package br.sp.fair.fredericoalves.skipthedishes.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Service Config
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("SkipTheDishes SP Fair")
                .description("SkipTheDishes Fair Services with Swagger")
                //.termsOfServiceUrl("http://fredericocerqueiraalves.blogspot.com/")                
                //.contact("Frederico Cerqueira Alves")
                .license("MIT License")
                //.licenseUrl("http://api-vanhack-event-sp.azurewebsites.net/swagger/")
                .version("1.0")
                .build();
    }

    /**
     * Doc Info API
     *
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).enable(true)
                .groupName("skipthedishes-sp-fair")
                .apiInfo(getApiInfo())
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("br.sp.fair.fredericoalves.skipthedishes"))
                .paths(regex("/api.*"))
                .build();
    }

}
