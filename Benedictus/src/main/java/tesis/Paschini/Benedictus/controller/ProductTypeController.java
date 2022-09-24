package tesis.Paschini.Benedictus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.ProductType;
import tesis.Paschini.Benedictus.repository.ProductTypeRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product_types/")
public class ProductTypeController {


    @Autowired
    ProductTypeRepository productTypeRepository;

    @GetMapping
    public List<ProductType> getAllProductTypes(){
        return productTypeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable long id){
        ProductType productType = productTypeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException( "Product Type not found with id " + id));
        return ResponseEntity.ok(productType);
    }

    @PostMapping
    public ProductType createProductType(@RequestBody ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductType> updateProductType(@PathVariable long id, @RequestBody ProductType productType){
        ProductType updateProductType = productTypeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException( "Product Type not found with id " + id));
        updateProductType.setLabel(productType.getLabel());

        productTypeRepository.save(updateProductType);
        return ResponseEntity.ok(updateProductType);
    }
}
