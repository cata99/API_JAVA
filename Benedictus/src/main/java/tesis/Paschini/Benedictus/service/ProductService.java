package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Optional<Product> getProductById(long id);

    Product updateProduct(Product updatedProduct);

    void deleteProduct(long id);
}