package com.stefanengineering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initRepository(UserRepository repository) {
        return (args) -> {
            repository.save(new User("Stefan", "Eng"));
            repository.save(new User("John", "Smith"));
            repository.save(new User("Alex", "Johnson"));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");
        };
    }
}
