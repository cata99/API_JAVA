package tesis.Paschini.Benedictus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Attribute;
import tesis.Paschini.Benedictus.repository.AttributeRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/attributes/")
public class AttributeController {

    @Autowired
    AttributeRepository attributeRepository;

    @GetMapping
    public List<Attribute> getAllAttributes(){
        return attributeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable long id){
        Attribute attribute = attributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return  ResponseEntity.ok(attribute);
    }


    @PostMapping
    public Attribute createAttribute(@RequestBody Attribute attribute){
        return attributeRepository.save(attribute);
    }

    @PutMapping("{id}")
    public ResponseEntity<Attribute> updateAttribute(@PathVariable long id, @RequestBody Attribute attribute){
        Attribute updateAttribute = attributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateAttribute.setField(attribute.getField());
        updateAttribute.setUnit(attribute.getUnit());

        attributeRepository.save(updateAttribute);

        return ResponseEntity.ok(updateAttribute);
    }
}
