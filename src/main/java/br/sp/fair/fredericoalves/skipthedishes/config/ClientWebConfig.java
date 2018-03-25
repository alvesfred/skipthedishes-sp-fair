package br.sp.fair.fredericoalves.skipthedishes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Client Web Config
 *
 * @author frederico.alves
 *
 */
@EnableWebMvc
@Configuration
public class ClientWebConfig extends WebMvcConfigurerAdapter {

    public ClientWebConfig() {
        super();
    }
}