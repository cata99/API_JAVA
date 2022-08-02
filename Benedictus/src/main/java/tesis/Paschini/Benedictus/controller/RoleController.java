package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Role;
import tesis.Paschini.Benedictus.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/Roles/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }

    @PostMapping
    public Role createAttribute(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Role role = roleService.getRoleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("role not exist with id:" + id));

        return ResponseEntity.ok(role);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole( @PathVariable(value = "id" ) Long id , @RequestBody Role roleDetails) throws ResourceNotFoundException{
        Role role= roleService.getRoleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not exist with id:" + id));

        role.setLabel(roleDetails.getLabel());
        final Role updatedRole = roleService.updateRole(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReport (@PathVariable(value = "id") Long reportId) throws ResourceNotFoundException {
        roleService.deleteRole(reportId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }

}
