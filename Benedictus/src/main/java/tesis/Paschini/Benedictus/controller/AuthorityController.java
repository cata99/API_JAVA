package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Authority;
import tesis.Paschini.Benedictus.repository.AuthorityRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/authorities/")
public class AuthorityController {

    @Autowired
    AuthorityRepository authorityRepository;

    @GetMapping
    public List<Authority> getAllAuthorities(){
        return authorityRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Authority> getAuthorityById(@PathVariable long id){
        Authority authority = authorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(authority);
    }

    @PostMapping
    public Authority createAuthority(@RequestBody Authority authority){
        return authorityRepository.save(authority);
    }

    @PutMapping
    public ResponseEntity<Authority> updateAuthority(@PathVariable long id, @RequestBody Authority authority){
        Authority updateAuthority= authorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateAuthority.setLocation(authority.getLocation());
        updateAuthority.setPhone(authority.getPhone());
        updateAuthority.setLabel(authority.getLabel());

        authorityRepository.save(updateAuthority);

        return ResponseEntity.ok(updateAuthority);
    }
}
