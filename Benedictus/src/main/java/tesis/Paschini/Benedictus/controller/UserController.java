package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.PersonalInformation;
import tesis.Paschini.Benedictus.model.User;
import tesis.Paschini.Benedictus.repository.PersonalInformationRepository;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonalInformationRepository personalInformationRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countUsers() {

        long amount = userRepository.count();

        Map<String, Object> payload = new HashMap<>();
        payload.put("count", amount
        );

        return ResponseEntity.ok(payload);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user, PersonalInformation personalInformation) {
        personalInformationRepository.save(personalInformation);
        User user1= new User();
        user1.setPersonalInformation(personalInformationRepository.findByEmail(personalInformation.getEmail()));
        user1.setUsername(user.getUsername());
        user1.setGroup(user.getGroup());
        user1.setActive(true);
        user1.setPassword(user.getPassword());
        Date date = new Date();
        user1.setDateOfStart(date);

        return userRepository.save(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User updateUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateUser.setUsername(user.getUsername());
        updateUser.setActive(user.getActive());
        updateUser.setDateOfStart(user.getDateOfStart());
        updateUser.setGroup(user.getGroup());
        updateUser.setExpirationDate(user.getExpirationDate());
        updateUser.setPassword(user.getPassword());
        updateUser.setPersonalInformation(user.getPersonalInformation());
        updateUser.setToken(user.getToken());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }
}
