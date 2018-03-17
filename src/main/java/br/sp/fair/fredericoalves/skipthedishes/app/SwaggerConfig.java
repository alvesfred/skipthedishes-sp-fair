package br.sp.fair.fredericoalves.skipthedishes.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
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

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SkipTheDishes SP Fair")
                .description("SkipTheDishes Fair Services with Swagger")
                //.termsOfServiceUrl("http://fredericocerqueiraalves.blogspot.com/")                
                //.contact("Frederico Cerqueira Alves")
                .license("Apache License Version 2.0")
                //.licenseUrl("http://api-vanhack-event-sp.azurewebsites.net/swagger/")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket personApi() {
        return new Docket(DocumentationType.SWAGGER_2).enable(true)
                .groupName("corenode")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }

}
