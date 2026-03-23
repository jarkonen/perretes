package com.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        // Esta línea arranca el servidor Tomcat interno
        SpringApplication.run(App.class, args);
    }
}