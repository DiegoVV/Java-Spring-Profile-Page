package com.example.profile.phone;

import com.example.profile.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table
@ToString
public class Phone {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
//    private Long user_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String phone;

    public Phone() {

    }

    public Phone(Long id, User user, String phone) {
        this.id = id;
        this.user = user;
        this.phone = phone;
    }

    public Phone(User user, String phone) {
        this.user = user;
        this.phone = phone;
    }

    public Phone(String phone) {
        this.user = null;
        this.phone = phone;
    }

//    public Phone(Long id, Long user_id, String phone) {
//        this.id = id;
//        this.user_id = user_id;
//        this.phone = phone;
//    }
//
//    public Phone(Long user_id, String phone) {
//        this.user_id = user_id;
//        this.phone = phone;
//    }
}