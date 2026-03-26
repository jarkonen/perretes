package com.ejemplo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitimos que el Frontend (que correrá en el puerto 5173 por defecto con Vite)
        // pueda hacer peticiones a nuestra API.
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "http://192.168.1.129:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
