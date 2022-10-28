package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.DonationProduct;
import tesis.Paschini.Benedictus.model.Product;

public interface DonationProductRepository extends JpaRepository<DonationProduct, Long> {

    @Query("select sum(p.quantity) from DonationProduct p where p.product = :product")
    Long getQuantityByProducts(@RequestParam("product") Product product);
}
