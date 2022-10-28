package tesis.Paschini.Benedictus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.DeliveryQuantity;
import tesis.Paschini.Benedictus.model.Product;

public interface DeliveryQuantityRepository extends JpaRepository<DeliveryQuantity, Long> {

    @Query("select sum(p.quantity) from DeliveryQuantity p where p.product = :product")
    Long getQuantityByProducts(@RequestParam("product") Product product);
}
