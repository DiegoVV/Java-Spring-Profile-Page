package com.example.profile.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="user_profile")
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
    private String phone;
    private String address;
    private String password;

    public User() {

    }

    public User(Long id, String address, LocalDate birthday, String email, String name, String password, String phone) {
        this.id = id;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public User(String address, LocalDate birthday, String email, String name, String password, String phone) {
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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