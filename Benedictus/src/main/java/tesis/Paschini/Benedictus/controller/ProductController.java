package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Product;
import tesis.Paschini.Benedictus.repository.ProductRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product product = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException( "Product Type not found with id " + id));
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public Product createProducts(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        Product updateProduct = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException( "Product not found with id " + id));
        updateProduct.setProductType(product.getProductType());
        updateProduct.setLabel(product.getLabel());

        productRepository.save(updateProduct);
        return ResponseEntity.ok(updateProduct);
    }

}
