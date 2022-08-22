package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.InstitutionDisease;
import tesis.Paschini.Benedictus.repository.InstitutionDiseaseRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/institutions_disease/")
public class InstitutionDiseaseController {

    @Autowired
    InstitutionDiseaseRepository institutionDiseaseRepository;

    @GetMapping
    public List<InstitutionDisease> getAllInstitutionDisease(){
        return institutionDiseaseRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<InstitutionDisease> getInstitutionDiseaseById(@PathVariable long id){
        InstitutionDisease institutionDisease = institutionDiseaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(institutionDisease);
    }

    @PostMapping
    public InstitutionDisease createInstitutionDisease(@RequestBody InstitutionDisease institutionDisease){
        return institutionDiseaseRepository.save(institutionDisease);
    }

    @PutMapping("{id}")
    public ResponseEntity<InstitutionDisease>  updateInstitutionDisease(@PathVariable long id,@RequestBody InstitutionDisease institutionDisease){
        InstitutionDisease updateInstitutionDisease= institutionDiseaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateInstitutionDisease.setDisease(institutionDisease.getDisease());
        updateInstitutionDisease.setInstitution(institutionDisease.getInstitution());

        return ResponseEntity.ok(updateInstitutionDisease);
    }
}
