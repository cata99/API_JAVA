package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Institution;
import tesis.Paschini.Benedictus.repository.InstitutionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/institutions/")
public class InstitutionController {

    @Autowired
    InstitutionRepository institutionRepository;

    @GetMapping
    public List<Institution> getAllInstitution() {
        return institutionRepository.findAll();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countInstitutions() {

        long amount= institutionRepository.count();

        Map<String, Object> payload = new HashMap<>();
        payload.put("count", amount
        );

        return ResponseEntity.ok(payload);
    }



    @GetMapping("{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable long id) {
        Institution institution = institutionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(institution);
    }

    @PostMapping
    public Institution createInstitution(@RequestBody Institution institution) {
        return institutionRepository.save(institution);
    }

    @PutMapping("{id}")
    public ResponseEntity<Institution> updateInstitution(@PathVariable long id, @RequestBody Institution institution) {
        Institution updateInstitution = institutionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateInstitution.setLocation(institution.getLocation());
        updateInstitution.setName(institution.getName());
        updateInstitution.setPhone(institution.getPhone());

        institutionRepository.save(updateInstitution);

        return ResponseEntity.ok(updateInstitution);
    }
}
