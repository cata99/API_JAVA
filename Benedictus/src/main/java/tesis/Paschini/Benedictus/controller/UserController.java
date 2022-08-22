package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.User;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<User> getAttributeById(@PathVariable long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateUser.setUser(user.getUser());
        updateUser.setActive(user.getActive());
        updateUser.setDateOfStart(user.getDateOfStart());
        updateUser.setGroup(user.getGroup());
        updateUser.setExpirationDate(user.getExpirationDate());
        updateUser.setPassword(user.getPassword());
        updateUser.setPersonalInformation(user.getPersonalInformation());
        updateUser.setToken(user.getToken());
        updateUser.setRolesSet(user.getRolesSet());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }
}
