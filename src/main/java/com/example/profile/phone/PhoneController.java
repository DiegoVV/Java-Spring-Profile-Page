package com.example.profile.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/phone")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService userService) {
        this.phoneService = userService;
    }

    @GetMapping
    public List<Phone> getPhones() {
        return phoneService.getPhones();
    }

    @GetMapping("/{id}")
    public Phone getPhone(@PathVariable("id") Long id) {
//        return userService.getUsers().get(Math.toIntExact(id));
        return phoneService.getPhone(id);
    }

    @PostMapping
    public Phone addPhone(@RequestBody Phone phone) {
        return phoneService.addPhone(phone);
    }

    @PutMapping("/{phoneId}/users/{userId}")
    public Phone addUserToPhone(@PathVariable("phoneId") Long phoneId, @PathVariable("userId") Long userId) {
        return phoneService.addUserToPhone(phoneId, userId);
    }

    @GetMapping("/users/{userId}")
    public List<Phone> getUserPhones(@PathVariable("userId") Long userId) {
        return phoneService.getUserPhones(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePhone(@PathVariable("id") Long id){
        return phoneService.deletePhone(id);
    }
}
