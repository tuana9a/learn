package com.tuana9a.learnjavaspringweb.security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")              //EXPLAIN: xác định URI
                .allowedOrigins("*")                            //EXPLAIN: các domain cho phép
                .allowedMethods("PUT", "DELETE", "GET", "POST")    //EXPLAIN: các method cho phép
                .allowedHeaders("*");                           //EXPLAIN: các headers cho phép
    }
}
