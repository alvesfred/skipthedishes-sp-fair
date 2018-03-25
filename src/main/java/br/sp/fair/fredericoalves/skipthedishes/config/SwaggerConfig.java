package br.sp.fair.fredericoalves.skipthedishes.config;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
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
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.sp.fair.fredericoalves.skipthedishes"))
				.paths(PathSelectors.ant("/api/**/*"))
				.build()
				.apiInfo(getApiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET,
						newArrayList(
								new ResponseMessageBuilder().code(500).message("500 message")
										.responseModel(new ModelRef("Error")).build(),
								new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
	}

//    @Bean
//    public Docket api() {
//      Docket docket = new Docket(DocumentationType.SWAGGER_2)
//    		  .apiInfo(getApiInfo())
//              .genericModelSubstitutes(ResponseEntity.class)
//              .forCodeGeneration(true)
//              .genericModelSubstitutes(ResponseEntity.class)
//              .directModelSubstitute(LocalDate.class, String.class)
//              .directModelSubstitute(LocalDateTime.class, Date.class)
//              .directModelSubstitute(ZonedDateTime.class, Date.class)
//              .select()
//              .paths(regex("/api/.*")).build();
//      return docket;
//    }
}
