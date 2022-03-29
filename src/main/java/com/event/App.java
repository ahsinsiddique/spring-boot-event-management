//****************************************************************
//* Copyright (c) 2021 . All Rights Reserved.
//****************************************************************
package com.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The starting point for the CMS web application and main Spring configuration class.
 *
 * The @SpringBootApplication is a convenience annotation that adds the following:
 * - tags this class as a source of bean definitions for Java based Spring Framework configuration
 * - Enables auto configuration of other beans and properties settings found on the classpath
 * - Enables Spring MVC, which tells Spring that this is a web application and activates the
 *   Spring MVC Dispatcher Servlet.
 * - Enables Component Scan to tell Spring to look for other components, configurations and services
 *   in the com.ford.cms package and packages under com.ford.cms.
 * - The @SpringBootApplication annotation is the same as specifying the following
 *   annotations: @Configuration, @EnableAutoConfiguration, @EnableWebMvc, @ComponentScan
 *
 * If this application requires any additional Spring configuration beyond what
 * Spring Boot auto-configuration provides, the addition configuration should be
 * put into one or more separate @Configuration-configured classes rather than
 * adding the configuration directly to this class. The other configuration classes
 * will be picked up and used by component-scanning.
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer {

    /**
     * Required in order to deploy as a war file on a servlet container such as Tomcat
     * @see https://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
    /**
     * Invoked by Spring Boot to start the app. 
     */
    public static void main(String[] args) {
        // Launch the application by passing a reference to the App class to
        // SpringApplication.run() along with any command line arguments.
        SpringApplication.run(App.class, args);
    }
}
