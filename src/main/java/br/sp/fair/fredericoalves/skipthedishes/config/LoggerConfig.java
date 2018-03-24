package br.sp.fair.fredericoalves.skipthedishes.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Logger config
 *
 * @author frederico.alves
 *
 */
@Configuration
@ComponentScan
public class LoggerConfig {
	@Bean
	@Scope("prototype")
	public Logger logger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(
				injectionPoint.getMethodParameter().getContainingClass());
	}
}
