package com.example.profile.user;

import com.example.profile.phone.Phone;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringContains.containsString;

public class UserControllerTest {

//    @Test
//    void hello() {
//        UserController controller = new UserController(new UserService()); //Arrange
//        String response = controller.hello("World"); //Act
//        assertEquals("Hello, World", response); //Assert
//    }

    UserController userController;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Starting User Controller Tests");
    }

    @BeforeEach
    public void setup() {
        userController = new UserController(new UserService(new UserRepository() {
            @Override
            public Optional<User> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public List<User> findAll() {
                return null;
            }

            @Override
            public List<User> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<User> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends User> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends User> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public <S extends User> List<S> saveAllAndFlush(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<User> iterable) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public User getOne(Long aLong) {
                return null;
            }

            @Override
            public User getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends User> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<User> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends User> S save(S s) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User user) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends User> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends User> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends User> boolean exists(Example<S> example) {
                return false;
            }
        }));

    }

    @Test
    public void addTwoPhoneNumbersToOneUserTest()
            throws JsonProcessingException {

        User user = new User(
                "Postman",
                "post@gmail.mail",
                LocalDate.of(1993, 2, 9),
                "Space",
                "password");

        Phone phone = new Phone("55 51 982569283");
        phone.setUser(user);
        Phone phone2 = new Phone("55 51 977777777");
        phone2.setUser(user);
        Set<Phone> phoneNumbers = new HashSet<>();
        phoneNumbers.add(phone);
        phoneNumbers.add(phone2);

        user.setPhone(phoneNumbers);

        ObjectMapper result = new ObjectMapper();
        result.registerModule(new JavaTimeModule());
        result.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String now = result.writeValueAsString(phone);
        String now2 = result.writeValueAsString(phone2);

        assertThat(now, containsString("55 51 982569283"));
        assertThat(now, containsString("Postman"));
        assertThat(now, not(containsString("userItems")));
        assertThat(now2, containsString("55 51 977777777"));
        assertThat(now2, containsString("Postman"));
    }

    @Test
    public void AuthenticateUserTest()
            throws JsonProcessingException {

        User user = new User(
                "Postman",
                "post@gmail.mail",
                LocalDate.of(1993, 2, 9),
                "Space",
                "password");
    }

    @Test
    void getUser() {
    }

    @Test
    void validateUser() {
    }

    @Test
    void addUser() {
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Finished All User Controller Tests");
    }

}
