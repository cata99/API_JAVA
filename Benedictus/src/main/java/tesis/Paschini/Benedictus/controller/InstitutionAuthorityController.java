package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.InstitutionAuthority;
import tesis.Paschini.Benedictus.repository.InstitutionAuthorityRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/institutions_authority/")
public class InstitutionAuthorityController {


    @Autowired
    InstitutionAuthorityRepository institutionAuthorityRepository;

    @GetMapping
    public List<InstitutionAuthority> getAllInstitutionAuthority(){
        return institutionAuthorityRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<InstitutionAuthority> getInstitutionAuthorityById(@PathVariable long id){
        InstitutionAuthority institutionAuthority = institutionAuthorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(institutionAuthority);
    }

    @PostMapping
    public InstitutionAuthority createInstitutionAuthority(@RequestBody InstitutionAuthority institutionAuthority){
        return institutionAuthorityRepository.save(institutionAuthority);
    }

    @PutMapping("{id}")
    public ResponseEntity<InstitutionAuthority>  updateInstitutionAuthority(@PathVariable long id,@RequestBody InstitutionAuthority institutionAuthority){
        InstitutionAuthority updateInstitutionAuthority= institutionAuthorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateInstitutionAuthority.setAuthority(institutionAuthority.getAuthority());
        updateInstitutionAuthority.setInstitution(institutionAuthority.getInstitution());

        return ResponseEntity.ok(updateInstitutionAuthority);
    }
}
