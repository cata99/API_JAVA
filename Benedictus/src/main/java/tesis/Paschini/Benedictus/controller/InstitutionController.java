package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Institution;
import tesis.Paschini.Benedictus.service.InstitutionService;

import java.util.List;

@RestController
@RequestMapping("/api/Institutions/")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @GetMapping
    public List<Institution> getAllInstitution() {
        return institutionService.getAllInstitution();
    }

    @PostMapping
    public Institution createAttribute(@RequestBody Institution institution) {
        return institutionService.saveInstitution(institution);
    }

    @GetMapping("{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Institution institution = institutionService.getInstitutionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("institution not exist with id:" + id));

        return ResponseEntity.ok(institution);
    }

    @PutMapping("{id}")
    public ResponseEntity<Institution> updateInstitution( @PathVariable(value = "id" ) Long id , @RequestBody Institution institutionDetails) throws ResourceNotFoundException{
        Institution institution= institutionService.getInstitutionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("institution not exist with id:" + id));

        institution.setName(institutionDetails.getName());
        institution.setDescription(institutionDetails.getDescription());
        institution.setLocation(institutionDetails.getLocation());
        institution.setPhone(institutionDetails.getPhone());

        final Institution updatedInstitution = institutionService.updateInstitution(institution);
        return ResponseEntity.ok(updatedInstitution);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInstitution (@PathVariable(value = "id") Long attributeId) throws ResourceNotFoundException {
        institutionService.deleteInstitution(attributeId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
