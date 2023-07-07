package com.baeldung.beanvalidation.application;

import com.baeldung.beanvalidation.application.entities.Uzer;
import com.baeldung.beanvalidation.application.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            Uzer uzer1 = new Uzer("Bob", "bob@domain.com");
            Uzer uzer2 = new Uzer("Jenny", "jenny@domain.com");
            userRepository.save(uzer1);
            userRepository.save(uzer2);
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
