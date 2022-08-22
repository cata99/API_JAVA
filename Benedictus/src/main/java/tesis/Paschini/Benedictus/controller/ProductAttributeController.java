package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ProductAttribute createProductAttribute(@RequestBody ProductAttribute productAttribute){
        return productAttributeRepository.save(productAttribute);
    }


}
