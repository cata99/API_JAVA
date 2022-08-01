package tesis.Paschini.Benedictus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Authority;
import tesis.Paschini.Benedictus.service.AuthorityService;

import java.util.List;

@RestController
@RequestMapping("/api/Authorities/")
public class AuthorityController {

    private AuthorityService authorityService;

    @GetMapping
    public List<Authority> getAllAuthority() {
        return authorityService.getAllAuthority();
    }

    @PostMapping
    public Authority createAuthority(@RequestBody Authority authority) {
        return authorityService.saveAuthority(authority);
    }

    @GetMapping("{id}")
    public ResponseEntity<Authority> getAuthorityById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Authority authority = authorityService.getAuthorityById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authority not exist with id:" + id));

        return ResponseEntity.ok(authority);
    }

    @PutMapping("{id}")
    public ResponseEntity<Authority> updateAuthority( @PathVariable(value = "id" ) Long id , @RequestBody Authority authorityDetails) throws ResourceNotFoundException{
        Authority authority= authorityService.getAuthorityById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authority not exist with id:" + id));

        authority.setLabel(authorityDetails.getLabel());
        authority.setLocation(authorityDetails.getLocation());
        authority.setPhone(authorityDetails.getPhone());
        authority.setTypeId(authorityDetails.getTypeId());

        final Authority updatedAuthority = authorityService.updateAuthority(authority);
        return ResponseEntity.ok(updatedAuthority);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttribute (@PathVariable(value = "id") Long attributeId) throws ResourceNotFoundException {
        authorityService.deleteAuthority(attributeId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
