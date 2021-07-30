package com.example.profile.phone;

//import lombok.AllArgsConstructor;

import com.example.profile.user.User;
import com.example.profile.user.UserRepository;
import org.hibernate.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//public class UserService implements UserDetailsService {
@Service
public class PhoneService {

    private final static String PHONE_NOT_FOUND_MSG = "phone not found";
    @Autowired
    private final PhoneRepository phoneRepository;
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, UserRepository userRepository) {
        this.phoneRepository = phoneRepository;
        this.userRepository = userRepository;
    }

    public List<Phone> getPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhone(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Phone with ID " + id + " does not exist"));
    }

    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone addUserToPhone(Long phoneId, Long userId) {
        Phone phone = phoneRepository.findById(phoneId).get();
//                .orElseThrow(() -> new PropertyNotFoundException("Phone with ID " + phoneId + " does not exist"));
        User user = userRepository.findById(userId).get();
//                .orElseThrow(() -> new PropertyNotFoundException("User with ID " + userId + " does not exist"));

//        phone.setUser_id(userId);
        phone.setUser(user);
        return phoneRepository.save(phone);
    }

    public List<Phone> getUserPhones(Long userId) {
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream().filter(phone -> (userId == (phone.getUser() == null ? null : phone.getUser().getId()))).collect(Collectors.toList());
    }

    public ResponseEntity<Map<String, Boolean>> deletePhone(Long id){
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Phone with ID " + id + " does not exist"));

        phoneRepository.delete(phone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("User deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
