package tesis.Paschini.Benedictus.serviceImpl;

import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Product;
import tesis.Paschini.Benedictus.repository.ProductRepository;
import tesis.Paschini.Benedictus.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository= productRepository;
    }

    @Override
    public Product saveProduct(Product product){
        Optional<Product> savedProduct = productRepository.findById(product.getId());
        if(savedProduct.isPresent()){
            throw new ResourceNotFoundException("Product already exist with given email:" + product.getId());
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product updatedProduct){
        return productRepository.save(updatedProduct);
    }

    @Override
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
}
