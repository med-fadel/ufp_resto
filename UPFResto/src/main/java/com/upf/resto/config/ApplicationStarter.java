package com.upf.resto.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "PROD");
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
