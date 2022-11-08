package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.*;
import tesis.Paschini.Benedictus.payload.request.UpdateUserRequest;
import tesis.Paschini.Benedictus.repository.GroupRepository;
import tesis.Paschini.Benedictus.repository.PersonalInformationRepository;
import tesis.Paschini.Benedictus.repository.RoleRepository;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonalInformationRepository personalInformationRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    RoleRepository roleRepository;

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

    @GetMapping("personal_information/{id}")
    public User getProducts(@PathVariable long id) {
        Optional<PersonalInformation> personalInformation = personalInformationRepository.findById(id);
        User user = userRepository.findUserByPersonalInformation(personalInformation);
        return user;


    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserRequest user) {
        User updateUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        PersonalInformation personalInformation = personalInformationRepository.getById(user.getPersonalInformation().getId());
        Group group = groupRepository.getById(user.getGroup().getId());

        updateUser.setUsername(user.getUsername());
        updateUser.setDateOfStart(user.getDateOfStart());
        updateUser.setGroup(group);
        updateUser.setPassword(user.getPassword());
        updateUser.setPersonalInformation(personalInformation);
        Set<String> strRoles = user.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_VOLUNTARIO)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else if ("referente".equals(role)) {
                    Role modRole = roleRepository.findByName(ERole.ROLE_REFERENTE)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);
                } else {
                    Role userRole = roleRepository.findByName(ERole.ROLE_VOLUNTARIO)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }

            });
        }
        updateUser.setRoles(roles);
        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }
}
