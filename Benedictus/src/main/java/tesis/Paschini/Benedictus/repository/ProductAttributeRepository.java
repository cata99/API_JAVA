package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.Product;
import tesis.Paschini.Benedictus.model.ProductAttribute;

import java.util.List;
import java.util.Optional;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

    @Query("select p from ProductAttribute p where p.product = :product")
    List<ProductAttribute> getAttributeProducts(@RequestParam("product") Optional<Product> product);

}
