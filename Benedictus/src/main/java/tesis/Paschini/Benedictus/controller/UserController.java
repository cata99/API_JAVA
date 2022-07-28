package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.User;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Users/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));

        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser( @PathVariable(value = "id" ) Long id , @RequestBody User userDetails) throws ResourceNotFoundException{
        User user= userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        user.setDateOfStart(userDetails.getDateOfStart());
        user.setGroupId(userDetails.getGroupId());
        user.setPassword(userDetails.getPassword());
        user.setReferent(userDetails.getReferent());
        user.setRoles(userDetails.getRoles());

     final User updatedUser = userRepository.save(user);
     return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user= userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + userId));

        user.setActive(false);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
