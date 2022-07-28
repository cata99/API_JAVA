package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Role;
import tesis.Paschini.Benedictus.repository.RoleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @PostMapping
    public Role createAttribute(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role not exist with id:" + id));

        return ResponseEntity.ok(role);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole( @PathVariable(value = "id" ) Long id , @RequestBody Role roleDetails) throws ResourceNotFoundException{
        Role role= roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not exist with id:" + id));

        role.setLabel(roleDetails.getLabel());
        final Role updatedRole = roleRepository.save(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long roleId) throws ResourceNotFoundException {
         Role role= roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + roleId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
