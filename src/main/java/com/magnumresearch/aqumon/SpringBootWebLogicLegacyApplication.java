package com.magnumresearch.aqumon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

//Tell Spring to automatically inject any dependencies that are marked in
//our classes with @Autowired
@EnableAutoConfiguration
// Tell Spring that this object represents a Configuration for the
// application
@Configuration
// SpringBootWebLogicLegacyApplication is a SpringBootServletInitializer subclass and override its configure method.
@ComponentScan
public class SpringBootWebLogicLegacyApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    static Logger logger = LoggerFactory.getLogger(SpringBootWebLogicLegacyApplication.class);

    // Tell Spring to launch our app!
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebLogicLegacyApplication.class, args);
        logger.info("this is a test message");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        logger.info("this is a test message in configure");

        return builder.sources(SpringBootWebLogicLegacyApplication.class).showBanner(false);
    }
}
