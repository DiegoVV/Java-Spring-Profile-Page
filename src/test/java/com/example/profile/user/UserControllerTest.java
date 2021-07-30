package com.example.profile.user;

import com.example.profile.phone.Phone;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
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

    @Test
    public void addTwoPhoneNumbersToOneUser()
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
        Set<Phone> phoneNumbers = new HashSet<Phone>();
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
}
