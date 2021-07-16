package com.example.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProfileApplication {

    public static void main(String[] args) {
    	SpringApplication.run(ProfileApplication.class, args);
    }

    @GetMapping
    public String hello() {
        return "Hey there";
    }

}
