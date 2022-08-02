package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Group;
import tesis.Paschini.Benedictus.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/Groups/")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroup();
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @GetMapping("{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Group group = groupService.getGroupById(id)
                .orElseThrow(() -> new ResourceNotFoundException("group not exist with id:" + id));

        return ResponseEntity.ok(group);
    }

    @PutMapping("{id}")
    public ResponseEntity<Group> updateGroup( @PathVariable(value = "id" ) Long id , @RequestBody Group groupDetails) throws ResourceNotFoundException{
        Group group= groupService.getGroupById(id)
                .orElseThrow(() -> new ResourceNotFoundException("group not exist with id:" + id));

        group.setInstitution(groupDetails.getInstitution());
        group.setLabel(groupDetails.getLabel());
        group.setUsers(groupDetails.getUsers());

        final Group updatedGroup = groupService.updateGroup(group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGroup (@PathVariable(value = "id") Long GroupId) throws ResourceNotFoundException {
        groupService.deleteGroup(GroupId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }

}
