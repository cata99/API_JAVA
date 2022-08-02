package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.User;
import tesis.Paschini.Benedictus.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/Users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));

        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser( @PathVariable(value = "id" ) Long id , @RequestBody User userDetails) throws ResourceNotFoundException{
        User user= userService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        user.setDateOfStart(userDetails.getDateOfStart());
        user.setGroupId(userDetails.getGroupId());
        user.setPassword(userDetails.getPassword());
        user.setReferent(userDetails.getReferent());
        user.setRoles(userDetails.getRoles());

     final User updatedUser = userService.updateUser(user);
     return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser (@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
