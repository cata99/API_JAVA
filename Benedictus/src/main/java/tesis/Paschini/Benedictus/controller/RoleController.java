package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Role;
import tesis.Paschini.Benedictus.repository.RoleRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roles/")
public class RoleController {
    
    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable long id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(role);
    }

    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role>  updateRole(@PathVariable long id,@RequestBody Role role){
        Role updateRole= roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateRole.setLabel(role.getLabel());
        updateRole.setUserSet(role.getUserSet());

        roleRepository.save(updateRole);

        return ResponseEntity.ok(updateRole);
    }
}
