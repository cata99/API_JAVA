package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.model.ProductAttribute;
import tesis.Paschini.Benedictus.repository.Product_AttributeRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product_attribute/")
public class Product_AttributeController {

    @Autowired
    private Product_AttributeRepository product_attributeRepository;

    @GetMapping
    public List<ProductAttribute> getAll(){
        return product_attributeRepository.findAll();
    }

    @PostMapping
    public ProductAttribute createProductAttribute(@RequestBody ProductAttribute productAttribute){
        return product_attributeRepository.save(productAttribute);
    }


}
