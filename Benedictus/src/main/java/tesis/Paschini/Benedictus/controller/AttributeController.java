package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Attribute;
import tesis.Paschini.Benedictus.service.AttributeService;

import java.util.List;

@RestController
@RequestMapping("/api/Attributes/")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;


    @GetMapping
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttribute();
    }

    @PostMapping
    public Attribute createAttribute(@RequestBody Attribute attribute) {
        return attributeService.saveAttribute(attribute);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Attribute attribute = attributeService.getAttributeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("attribute not exist with id:" + id));

        return ResponseEntity.ok(attribute);
    }

    @PutMapping("{id}")
    public ResponseEntity<Attribute> updateAttribute( @PathVariable(value = "id" ) Long id , @RequestBody Attribute attributeDetails) throws ResourceNotFoundException{
        Attribute attribute= attributeService.getAttributeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("attribute not exist with id:" + id));

        attribute.setField(attributeDetails.getField());
        attribute.setProduct(attributeDetails.getProduct());
        attribute.setUnitId(attributeDetails.getUnitId());
        attribute.setValue(attributeDetails.getValue());

        final Attribute updatedAttribute = attributeService.updateAttribute(attribute);
        return ResponseEntity.ok(updatedAttribute);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttribute (@PathVariable(value = "id") Long attributeId) throws ResourceNotFoundException {
        attributeService.deleteAttribute(attributeId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
