package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Product;
import tesis.Paschini.Benedictus.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createAttribute(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id:" + id));

        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct( @PathVariable(value = "id" ) Long id , @RequestBody Product productDetails) throws ResourceNotFoundException{
        Product product= productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id:" + id));

        product.setTypeOfProduct(productDetails.getTypeOfProduct());
        product.setName(productDetails.getName());

        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Product product= productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + productId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
