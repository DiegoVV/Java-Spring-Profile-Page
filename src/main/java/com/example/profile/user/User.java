package com.example.profile.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="user_profile")
@ToString
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate birthday;
    private String city;
    private String phone;
    private String password;
//    @Enumerated(EnumType.STRING)
//    private UserRole userRole;

    public User() {

    }

    public User(Long id, String name, String email, LocalDate birthday, String city, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.city = city;
        this.phone = phone;
        this.password = password;
    }

    public User(String name, String email, LocalDate birthday, String city, String phone, String password) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.city = city;
        this.phone = phone;
        this.password = password;
    }
}