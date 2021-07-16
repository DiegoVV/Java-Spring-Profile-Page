package com.example.profile.user;

import java.time.LocalDate;
import java.util.List;

public class UserService {
    public List<User> getUsers() {
        return List.of(
                new User(
                        26,
                        LocalDate.of(1995, 5, 19),
                        "email@gmail.mail",
                        1L,
                        "Diego"
                )
        );
    }
}
