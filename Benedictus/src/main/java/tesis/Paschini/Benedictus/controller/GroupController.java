package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Group;
import tesis.Paschini.Benedictus.repository.GroupRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<Group> getAllAttributes() {
        return groupRepository.findAll();
    }

    @PostMapping
    public Group createAttribute(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    @GetMapping("{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("group not exist with id:" + id));

        return ResponseEntity.ok(group);
    }

    @PutMapping("{id}")
    public ResponseEntity<Group> updateGroup( @PathVariable(value = "id" ) Long id , @RequestBody Group groupDetails) throws ResourceNotFoundException{
        Group group= groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("group not exist with id:" + id));

        group.setInstitution(groupDetails.getInstitution());
        group.setLabel(groupDetails.getLabel());
        group.setUsers(groupDetails.getUsers());

        final Group updatedGroup = groupRepository.save(group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long groupId) throws ResourceNotFoundException {
        Group group= groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + groupId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
