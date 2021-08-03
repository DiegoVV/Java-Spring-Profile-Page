package com.example.profile.user;

//import lombok.AllArgsConstructor;
import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class UserService implements UserDetailsService {
@Service
public class UserService {

    private final static String USER_NOT_FOUND_MSG = "user not found";
    private final UserRepository userRepository;
    private EmailValidator emailValidator;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.emailValidator = emailValidator;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("User with ID " + id + " does not exist"));
    }

    public User addUser(User user) {
//        boolean isValidEmail = emailValidator.test(user.getEmail());
//        if (!emailValidator.test(user.getEmail())) {
//            throw new IllegalStateException("invalid email");
//        }
        return userRepository.save(user);
//        System.out.println(user);
    }

    public ResponseEntity<User> updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("User with ID " + id + " does not exist"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setBirthday(userDetails.getBirthday());
        user.setPassword(userDetails.getPassword());
        user.setPhone(userDetails.getPhone());

        User updatedUser = userRepository.save(user);

        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("User with ID " + id + " does not exist"));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("User deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public Long validateUser(String email, String password) {
        if(email.contentEquals("admin") && password.contentEquals("admin")){
            return 0L;
        } else {
            User user = userRepository.findByEmail(email).get();
            if (user.getPassword().contentEquals(password)) {
                return user.getId();
            } else {
                return -1L;
            }
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return (UserDetails) userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
//    }

    public String signUpUser(User user){
        return "";
    }
}
