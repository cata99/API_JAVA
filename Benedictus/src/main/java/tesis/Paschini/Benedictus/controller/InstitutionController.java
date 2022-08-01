package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Institution;
import tesis.Paschini.Benedictus.repository.InstitutionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Institutions/")
public class InstitutionController {

    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping
    public List<Institution> getAllInstitution() {
        return institutionRepository.findAll();
    }

    @PostMapping
    public Institution createAttribute(@RequestBody Institution institution) {
        return institutionRepository.save(institution);
    }

    @GetMapping("{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Institution institution = institutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("institution not exist with id:" + id));

        return ResponseEntity.ok(institution);
    }

    @PutMapping("{id}")
    public ResponseEntity<Institution> updateInstitution( @PathVariable(value = "id" ) Long id , @RequestBody Institution institutionDetails) throws ResourceNotFoundException{
        Institution institution= institutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("institution not exist with id:" + id));

        institution.setName(institutionDetails.getName());
        institution.setDescription(institutionDetails.getDescription());
        institution.setLocation(institutionDetails.getLocation());
        institution.setPhone(institutionDetails.getPhone());

        final Institution updatedInstitution = institutionRepository.save(institution);
        return ResponseEntity.ok(updatedInstitution);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long institutionId) throws ResourceNotFoundException {
        Institution institution= institutionRepository.findById(institutionId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + institutionId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
