package tesis.Paschini.Benedictus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.AuthorityType;
import tesis.Paschini.Benedictus.service.AuthorityTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/AuthorityTypes/")
public class AuthorityTypeController {

    private AuthorityTypeService authorityTypeService;

    @GetMapping
    public List<AuthorityType> getAllAuthorityType() {
        return authorityTypeService.getAllAuthorityType();
    }

    @PostMapping
    public AuthorityType createAttributeType(@RequestBody AuthorityType authorityType) {
        return authorityTypeService.saveAuthorityType(authorityType);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorityType> getAuthorityTypeById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        AuthorityType authorityType = authorityTypeService.getAuthorityTypeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authorityType not exist with id:" + id));

        return ResponseEntity.ok(authorityType);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorityType> updateAuthorityType( @PathVariable(value = "id" ) Long id , @RequestBody AuthorityType authorityTypeDetails) throws ResourceNotFoundException{
        AuthorityType authorityType= authorityTypeService.getAuthorityTypeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("authorityType not exist with id:" + id));

        authorityType.setService(authorityType.getService());

        final AuthorityType updatedAuthorityType = authorityTypeService.updateAuthorityType(authorityType);
        return ResponseEntity.ok(updatedAuthorityType);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttribute (@PathVariable(value = "id") Long attributeId) throws ResourceNotFoundException {
        authorityTypeService.deleteAuthorityType(attributeId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }

}
