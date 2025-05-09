package com.guideMe.config; // Remplace par le package approprié

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Autoriser les demandes CORS depuis ton application Flutter
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "http://localhost:8080") // Remplace par l'URL de ton application Flutter
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}





