package com.example.profile.user;

import com.example.profile.phone.Phone;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
//            Phone diegoCell = new Phone(
//
//            );
//
//            Phone ednaCell = new Phone(
//
//            );
//
//            User diego = new User(
//                    "Diego Velasco",
//                    "email@gmail.mail",
//                    LocalDate.of(1995, 5, 19),
//                    "Porto Alegre",
//                    "password"
//            );
//
//            User edna = new User(
//                    "Edna Hernandez",
//                    "email2@gmail.mail",
//                    LocalDate.of(1993, 2, 9),
//                    "Honduras",
//                    "password"
//            );
//
//            repository.saveAll(
//                    List.of(diego, edna)
//            );
        };
    }
}
