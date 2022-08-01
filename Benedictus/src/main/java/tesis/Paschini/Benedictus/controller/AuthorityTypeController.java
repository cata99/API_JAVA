package tesis.Paschini.Benedictus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.AuthorityType;
import tesis.Paschini.Benedictus.repository.AuthorityTypeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/AuthorityTypes/")
public class AuthorityTypeController {

    private AuthorityTypeRepository authorityTypeRepository;

    @GetMapping
    public List<AuthorityType> getAllAuthorityType() {
        return authorityTypeRepository.findAll();
    }

    @PostMapping
    public AuthorityType createAttributeType(@RequestBody AuthorityType authorityType) {
        return authorityTypeRepository.save(authorityType);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorityType> getAuthorityTypeById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        AuthorityType authorityType = authorityTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authorityType not exist with id:" + id));

        return ResponseEntity.ok(authorityType);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorityType> updateAuthorityType( @PathVariable(value = "id" ) Long id , @RequestBody AuthorityType authorityTypeDetails) throws ResourceNotFoundException{
        AuthorityType authorityType= authorityTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authorityType not exist with id:" + id));

        authorityType.setService(authorityType.getService());

        final AuthorityType updatedAuthorityType = authorityTypeRepository.save(authorityType);
        return ResponseEntity.ok(updatedAuthorityType);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long authorityTypeId) throws ResourceNotFoundException {
        AuthorityType authorityType= authorityTypeRepository.findById(authorityTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + authorityTypeId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
