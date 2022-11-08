package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.Donation;
import tesis.Paschini.Benedictus.model.DonationProduct;
import tesis.Paschini.Benedictus.model.Product;

import java.util.List;
import java.util.Optional;

public interface DonationProductRepository extends JpaRepository<DonationProduct, Long> {

    @Query("select sum(p.quantity) from DonationProduct p where p.product = :product")
    Long getQuantityByProducts(@RequestParam("product") Product product);


    @Query("from DonationProduct q where q.donation = :donation")
    List<DonationProduct> getProductsByDonation(@RequestParam("donation") Optional<Donation> donation);
}
