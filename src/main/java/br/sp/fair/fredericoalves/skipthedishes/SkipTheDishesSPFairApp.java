package br.sp.fair.fredericoalves.skipthedishes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.gemfire.config.annotation.EnableStatistics;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SkipTheDishes Application Main
 *
 * @author Frederico Cerqueira Alves
 * @see fredericocerqueiraalves@gmail.com
 */
@SpringBootApplication
//@EntityScan(basePackages = { "br.sp.fair.fredericoalves.skipthedishes.model" })
//@EnableJpaRepositories(basePackages = { "br.sp.fair.fredericoalves.skipthedishes.repository" })
@EnableTransactionManagement
@EnableStatistics
@EnableCaching
@EnableScheduling
public class SkipTheDishesSPFairApp {

	final static String DEFAULT_PATH = "br.sp.fair.fredericoalves.skipthedishes";

	/**
	 * Main App
	 *
	 * @param args
	 */
    public static void main(String[] args) {
        final ApplicationContext applicationContext = SpringApplication.run(SkipTheDishesSPFairApp.class, args);
        String name;
        for (int i = 0; i < applicationContext.getBeanDefinitionNames().length; i++) {
        	name = applicationContext.getBeanDefinitionNames()[i];
            if (name.contains(DEFAULT_PATH)) 
            	System.out.println("Bean name: " + name);
        }
    }
}
