package br.sp.fair.fredericoalves.skipthedishes.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * SkipTheDishes Application Main
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@SpringBootApplication
@EnableJpaRepositories("br.sp.fair.fredericoalves.skipthedishes.repository")
@ComponentScan(basePackages = {"br"}, excludeFilters = {
    @ComponentScan.Filter(Configuration.class)})
//@EntityScan(basePackageClasses = Customer.class)
@EntityScan(basePackages = "br.sp.fair.fredericoalves.skipthedishes.model")
@Import({SpringConfig.class,HazelcastConfig.class})
@EnableCaching
public class SkipTheDishesApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(SkipTheDishesApplicationMain.class, args);
    }
}
