package br.sp.fair.fredericoalves.skipthedishes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web Config
 *
 * @author frederico.alves
 *
 */
@EnableWebMvc
@Configuration
@Import(SwaggerConfig.class)
@ComponentScan("br.sp.fair.fredericoalves.skipthedishes.resources")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("**/**")
			    .addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");

		registry.addResourceHandler("/webjars/**")
			    .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}