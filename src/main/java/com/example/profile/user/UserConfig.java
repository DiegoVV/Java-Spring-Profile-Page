package com.example.profile.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User diego = new User(
                    "Rua tal 555, ap 99",
                    LocalDate.of(1995, 5, 19),
                    "email@gmail.mail",
                    "Diego Velasco",
                    "password",
                    "55 51 912345678"
            );

            User edna = new User(
                    "Rua tal 545, ap 99",
                    LocalDate.of(1993, 2, 9),
                    "email2@gmail.mail",
                    "Edna Hernandez",
                    "password",
                    "55 51 922345678"
            );

            repository.saveAll(
                    List.of(diego, edna)
            );
        };
    }
}
