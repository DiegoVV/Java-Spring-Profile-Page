package com.example.profile.user;

import java.time.LocalDate;

public class User {
    private Integer age;
    private LocalDate birthday;
    private String email;
    private Long id;
    private String name;

    public User() {

    }

    public User(Integer age, LocalDate birthday, String email, Long id, String name) {
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public User(Integer age, LocalDate birthday, String email, String name) {
        this.birthday = birthday;
        this.email = email;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age = " + age +
                ", birthday = " + birthday +
                ", email = '" + email + '\'' +
                ", id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}