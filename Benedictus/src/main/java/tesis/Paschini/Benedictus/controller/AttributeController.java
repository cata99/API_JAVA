package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Attribute;
import tesis.Paschini.Benedictus.repository.AttributeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Attributes")
public class AttributeController {

    @Autowired
    private AttributeRepository attributeRepository;


    @GetMapping
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @PostMapping
    public Attribute createAttribute(@RequestBody Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Attribute attribute = attributeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("attribute not exist with id:" + id));

        return ResponseEntity.ok(attribute);
    }

    @PutMapping("{id}")
    public ResponseEntity<Attribute> updateAttribute( @PathVariable(value = "id" ) Long id , @RequestBody Attribute attributeDetails) throws ResourceNotFoundException{
        Attribute attribute= attributeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("attribute not exist with id:" + id));

        attribute.setField(attributeDetails.getField());
        attribute.setProduct(attributeDetails.getProduct());
        attribute.setUnitId(attributeDetails.getUnitId());
        attribute.setValue(attributeDetails.getValue());

        final Attribute updatedAttribute = attributeRepository.save(attribute);
        return ResponseEntity.ok(updatedAttribute);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long attributeId) throws ResourceNotFoundException {
        Attribute attribute= attributeRepository.findById(attributeId)
                .orElseThrow(() -> new ResourceNotFoundException("Attribute not exist with id:" + attributeId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
