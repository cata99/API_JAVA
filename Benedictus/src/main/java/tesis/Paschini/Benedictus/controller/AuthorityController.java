package tesis.Paschini.Benedictus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Authority;
import tesis.Paschini.Benedictus.repository.AuthorityRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Authorities/")
public class AuthorityController {

    private AuthorityRepository authorityRepository;

    @GetMapping
    public List<Authority> getAllAuthority() {
        return authorityRepository.findAll();
    }

    @PostMapping
    public Authority createAuthority(@RequestBody Authority authority) {
        return authorityRepository.save(authority);
    }

    @GetMapping("{id}")
    public ResponseEntity<Authority> getAuthorityById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Authority authority = authorityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authority not exist with id:" + id));

        return ResponseEntity.ok(authority);
    }

    @PutMapping("{id}")
    public ResponseEntity<Authority> updateAuthority( @PathVariable(value = "id" ) Long id , @RequestBody Authority authorityDetails) throws ResourceNotFoundException{
        Authority authority= authorityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authority not exist with id:" + id));

        authority.setLabel(authorityDetails.getLabel());
        authority.setLocation(authorityDetails.getLocation());
        authority.setPhone(authorityDetails.getPhone());
        authority.setTypeId(authorityDetails.getTypeId());

        final Authority updatedAuthority = authorityRepository.save(authority);
        return ResponseEntity.ok(updatedAuthority);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long authorityId) throws ResourceNotFoundException {
        Authority authority= authorityRepository.findById(authorityId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + authorityId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
