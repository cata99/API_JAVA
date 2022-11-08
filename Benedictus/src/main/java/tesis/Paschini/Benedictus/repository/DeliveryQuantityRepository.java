package tesis.Paschini.Benedictus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.Delivery;
import tesis.Paschini.Benedictus.model.DeliveryQuantity;
import tesis.Paschini.Benedictus.model.Product;

import java.util.List;
import java.util.Optional;

public interface DeliveryQuantityRepository extends JpaRepository<DeliveryQuantity, Long> {

    @Query("select sum(p.quantity) from DeliveryQuantity p where p.product = :product")
    Long getQuantityByProducts(@RequestParam("product") Product product);


    @Query("from DeliveryQuantity q where q.delivery = :delivery")
    List<DeliveryQuantity> getProductsByDelivery(@RequestParam("delivery") Optional<Delivery> delivery);
}
