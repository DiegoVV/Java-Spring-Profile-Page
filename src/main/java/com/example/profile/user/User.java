package com.example.profile.user;

import com.example.profile.phone.Phone;
import com.fasterxml.classmate.AnnotationOverrides;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
//    @OneToMany(targetEntity = Phone.class, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "phone",
//            joinColumns = @JoinColumn(name = "phone"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
////    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @OrderColumn
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Phone> phone;
    private String password;
//    @Enumerated(EnumType.STRING)
//    private UserRole userRole;

    public User() {

    }

    public User(Long id, String name, String email, LocalDate birthday, String city, Set<Phone> phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.city = city;
        this.phone = phone;
        this.password = password;
    }

    public User(String name, String email, LocalDate birthday, String city, Set<Phone> phone, String password) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.city = city;
        this.phone = phone;
        this.password = password;
    }

    public User(String name, String email, LocalDate birthday, String city, String password) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.city = city;
        this.phone = Collections.emptySet();
        this.password = password;
    }
}