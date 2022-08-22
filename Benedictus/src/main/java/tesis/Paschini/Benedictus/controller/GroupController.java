package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Group;
import tesis.Paschini.Benedictus.repository.GroupRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/groups/")
public class GroupController {
    
    @Autowired
    GroupRepository groupRepository;

    @GetMapping
    public List<Group> getAllGroup(){ return groupRepository.findAll();}

    @GetMapping("{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable long id){
        Group group= groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(group);
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group){
        return groupRepository.save(group);
    }

    @PutMapping("{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable long id, @RequestBody Group group){
        Group updateGroup = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateGroup.setLabel(group.getLabel());
        updateGroup.setInstitution(group.getInstitution());

        groupRepository.save(updateGroup);

        return ResponseEntity.ok(updateGroup);
    }
}
