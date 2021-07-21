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
                    "Diego Velasco",
                    "email@gmail.mail",
                    LocalDate.of(1995, 5, 19),
                    "Porto Alegre",
                    "55 51 912345678",
                    "password"
            );

            User edna = new User(
                    "Edna Hernandez",
                    "email2@gmail.mail",
                    LocalDate.of(1993, 2, 9),
                    "Honduras",
                    "55 51 922345678",
                    "password"
            );

            repository.saveAll(
                    List.of(diego, edna)
            );
        };
    }
}
