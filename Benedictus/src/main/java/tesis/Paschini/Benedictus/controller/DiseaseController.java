package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Disease;
import tesis.Paschini.Benedictus.repository.DiseaseRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/diseases/")
public class DiseaseController {

    @Autowired
    DiseaseRepository diseaseRepository;

    @GetMapping
    public List<Disease> getAllDisease(){ return diseaseRepository.findAll();}

    @GetMapping("{id}")
    public ResponseEntity<Disease> getDiseaseById(@PathVariable long id){
        Disease disease= diseaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(disease);
    }

    @PostMapping
    public Disease createDisease(@RequestBody Disease disease){
        return diseaseRepository.save(disease);
    }

    @PutMapping("{id}")
    public ResponseEntity<Disease> updateDisease(@PathVariable long id, @RequestBody Disease disease){
        Disease updateDisease = diseaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateDisease.setLabel(disease.getLabel());

        diseaseRepository.save(updateDisease);

        return ResponseEntity.ok(updateDisease);
    }
}
