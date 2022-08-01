package tesis.Paschini.Benedictus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Disease;
import tesis.Paschini.Benedictus.repository.DiseaseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Diseases/")
public class DiseaseController {

    private DiseaseRepository diseaseRepository;

    @GetMapping
    public List<Disease> getAllDisease() {
        return diseaseRepository.findAll();
    }

    @PostMapping
    public Disease createAttribute(@RequestBody Disease disease) {
        return diseaseRepository.save(disease);
    }

    @GetMapping("{id}")
    public ResponseEntity<Disease> getDiseaseById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Disease disease = diseaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("disease not exist with id:" + id));

        return ResponseEntity.ok(disease);
    }

    @PutMapping("{id}")
    public ResponseEntity<Disease> updateDisease( @PathVariable(value = "id" ) Long id , @RequestBody Disease diseaseDetails) throws ResourceNotFoundException{
        Disease disease= diseaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("disease not exist with id:" + id));

        disease.setLabel(diseaseDetails.getLabel());

        final Disease updatedDisease = diseaseRepository.save(disease);
        return ResponseEntity.ok(updatedDisease);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long diseaseId) throws ResourceNotFoundException {
        Disease disease= diseaseRepository.findById(diseaseId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + diseaseId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
