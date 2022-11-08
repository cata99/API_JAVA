package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Product;
import tesis.Paschini.Benedictus.model.ProductAttribute;
import tesis.Paschini.Benedictus.repository.ProductAttributeRepository;
import tesis.Paschini.Benedictus.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product_attribute/")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductAttribute> getAll() {
        return productAttributeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity getProductAttributeById(@PathVariable long id) {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(productAttribute);
    }

    @GetMapping("attributes/{id}")
    public List<ProductAttribute> getProducts(@PathVariable long id) {

        Optional<Product> product = productRepository.findById(id);
        List<ProductAttribute> list = productAttributeRepository.getAttributeProducts(product);
        return list;


    }

    @PostMapping
    public ProductAttribute createProductAttribute(@RequestBody ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductAttribute> updateLifeEvent(@PathVariable long id, @RequestBody ProductAttribute productAttribute) {
        ProductAttribute updateProductAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateProductAttribute.setAttribute(productAttribute.getAttribute());
        updateProductAttribute.setProduct(productAttribute.getProduct());
        updateProductAttribute.setValue(productAttribute.getValue());


        return ResponseEntity.ok(updateProductAttribute);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteDonation(@PathVariable(value = "id") Long productAttributeId)
            throws ResourceNotFoundException {
        ProductAttribute productAttribute = productAttributeRepository.findById(productAttributeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + productAttributeId));

        productAttributeRepository.delete(productAttribute);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
