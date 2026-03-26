package com.ejemplo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner initData(PerroRepository repository) {
        return args -> {
            // Solo añadimos si está vacía para no duplicar en reinicios con persistencia
            if (repository.count() == 0) {
                repository.save(new Perro("Rex", "Pastor Alemán", 5));
                repository.save(new Perro("Laika", "Siberian Husky", 3));
                repository.save(new Perro("Toby", "Golden Retriever", 2));
                System.out.println("Base de Datos inicializada con 3 perretes 🐾");
            }
        };
    }
}