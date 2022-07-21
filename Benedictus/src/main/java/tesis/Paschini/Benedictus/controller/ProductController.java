package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.Paschini.Benedictus.repository.ProductRepository;

@RestController
@RequestMapping("/api/Products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
}
