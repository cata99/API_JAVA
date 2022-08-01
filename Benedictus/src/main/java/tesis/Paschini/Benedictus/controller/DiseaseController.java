package tesis.Paschini.Benedictus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Disease;
import tesis.Paschini.Benedictus.service.DiseaseService;

import java.util.List;

@RestController
@RequestMapping("/api/Diseases/")
public class DiseaseController {

    private DiseaseService diseaseService;

    @GetMapping
    public List<Disease> getAllDisease() {
        return diseaseService.getAllDisease();
    }

    @PostMapping
    public Disease createAttribute(@RequestBody Disease disease) {
        return diseaseService.saveDisease(disease);
    }

    @GetMapping("{id}")
    public ResponseEntity<Disease> getDiseaseById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Disease disease = diseaseService.getDiseaseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("disease not exist with id:" + id));

        return ResponseEntity.ok(disease);
    }

    @PutMapping("{id}")
    public ResponseEntity<Disease> updateDisease( @PathVariable(value = "id" ) Long id , @RequestBody Disease diseaseDetails) throws ResourceNotFoundException{
        Disease disease= diseaseService.getDiseaseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("disease not exist with id:" + id));

        disease.setLabel(diseaseDetails.getLabel());

        final Disease updatedDisease = diseaseService.updateDisease(disease);
        return ResponseEntity.ok(updatedDisease);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttribute (@PathVariable(value = "id") Long attributeId) throws ResourceNotFoundException {
        diseaseService.deleteDisease(attributeId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
