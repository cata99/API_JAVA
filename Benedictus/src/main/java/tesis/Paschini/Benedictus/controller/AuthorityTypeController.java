package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.AuthorityType;
import tesis.Paschini.Benedictus.repository.AuthorityTypeRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/authorities_types/")
public class AuthorityTypeController {

    @Autowired
    AuthorityTypeRepository authorityTypeRepository;

    @GetMapping
    public List<AuthorityType> getAllAuthorityType(){
        return authorityTypeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorityType> getAuthorityTypeById(@PathVariable long id){
        AuthorityType authorityType = authorityTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(authorityType);
    }

    @PostMapping
    public AuthorityType createAuthorityType(@RequestBody AuthorityType authorityType){
        return authorityTypeRepository.save(authorityType);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorityType> updateAuthorityType(@PathVariable long id, @RequestBody AuthorityType authorityType){
        AuthorityType updateAuthorityType = authorityTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateAuthorityType.setService(authorityType.getService());

        authorityTypeRepository.save(updateAuthorityType);

        return ResponseEntity.ok(updateAuthorityType);
    }
}
