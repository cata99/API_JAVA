package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.model.Product;
import tesis.Paschini.Benedictus.repository.ProductRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
