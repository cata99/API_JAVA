package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.User;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countUsers() {

        long amount= userRepository.count();

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


    @PutMapping
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateUser.setUsername(user.getUsername());
        updateUser.setActive(user.getActive());
        updateUser.setDateOfStart(user.getDateOfStart());
        updateUser.setGroup(user.getGroup());
        updateUser.setPassword(user.getPassword());
        updateUser.setPersonalInformation(user.getPersonalInformation());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }
}
