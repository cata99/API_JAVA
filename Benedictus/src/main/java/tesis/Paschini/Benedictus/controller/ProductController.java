package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Product;
import tesis.Paschini.Benedictus.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/Products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProduct();
    }

    @PostMapping
    public Product createAttribute(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id:" + id));

        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct( @PathVariable(value = "id" ) Long id , @RequestBody Product productDetails) throws ResourceNotFoundException{
        Product product= productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id:" + id));

        product.setTypeOfProduct(productDetails.getTypeOfProduct());
        product.setName(productDetails.getName());

        final Product updatedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        productService.deleteProduct(productId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
