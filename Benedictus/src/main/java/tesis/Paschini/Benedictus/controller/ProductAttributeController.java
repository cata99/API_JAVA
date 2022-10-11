package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.ProductAttribute;
import tesis.Paschini.Benedictus.repository.ProductAttributeRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product_attribute/")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @GetMapping
    public List<ProductAttribute> getAll(){
        return productAttributeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity getProductAttributeById(@PathVariable long id){
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(productAttribute);
    }

    @PostMapping
    public ProductAttribute createProductAttribute(@RequestBody ProductAttribute productAttribute){
        return productAttributeRepository.save(productAttribute);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductAttribute> updateLifeEvent(@PathVariable long id, @RequestBody ProductAttribute productAttribute){
        ProductAttribute updateProductAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateProductAttribute.setAttribute(productAttribute.getAttribute());
        updateProductAttribute.setProduct(productAttribute.getProduct());
        updateProductAttribute.setValue(productAttribute.getValue());


        return ResponseEntity.ok(updateProductAttribute);
    }


}
