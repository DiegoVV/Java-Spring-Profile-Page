package com.example.profile.user;

//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//public class UserService implements UserDetailsService {
@Service
public class UserService {

    private final static String USER_NOT_FOUND_MSG = "user not found";
    private final UserRepository userRepository;
    private EmailValidator emailValidator;

    @Autowired
    public UserService(UserRepository userRepository, EmailValidator emailValidator) {
        this.userRepository = userRepository;
        this.emailValidator = emailValidator;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
//        boolean isValidEmail = emailValidator.test(user.getEmail());
        if (!emailValidator.test(user.getEmail())) {
            throw new IllegalStateException("invalid email");
        }
        return userRepository.save(user);
//        System.out.println(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return (UserDetails) userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
//    }

    public String signUpUser(User user){
        return "";
    }
}
