package br.sp.fair.fredericoalves.skipthedishes;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Template Config for POST, GET, DELETE, UPDATE requests on Restfull JSON calls
 *
 * @author frederico.alves
 *
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

}
