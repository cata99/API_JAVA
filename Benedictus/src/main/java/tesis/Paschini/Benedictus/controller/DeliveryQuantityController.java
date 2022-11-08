package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tesis.Paschini.Benedictus.model.Delivery;
import tesis.Paschini.Benedictus.model.DeliveryQuantity;
import tesis.Paschini.Benedictus.model.Product;
import tesis.Paschini.Benedictus.repository.DeliveryQuantityRepository;
import tesis.Paschini.Benedictus.repository.DeliveryRepository;
import tesis.Paschini.Benedictus.repository.DonationProductRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/deliveries_quantities/")
public class DeliveryQuantityController {

    @Autowired
    DeliveryQuantityRepository deliveryQuantityRepository;

    @Autowired
    DonationProductRepository donationProductRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @GetMapping("products/{id}")
    public List<DeliveryQuantity> getProducts(@PathVariable long id){

        Optional<Delivery> delivery = deliveryRepository.findById(id);
        return deliveryQuantityRepository.getProductsByDelivery(delivery);


    }

    @GetMapping
    public List<DeliveryQuantity> findAll() {
        return deliveryQuantityRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<DeliveryQuantity> createDeliveryQuantity(@RequestBody DeliveryQuantity deliveryQuantity) {

        Product product = deliveryQuantity.getProduct();
        Long donationsQuantity = donationProductRepository.getQuantityByProducts(product);
        Long deliveryQuantityTotal;
        if (deliveryQuantityRepository.getQuantityByProducts(product) == null) {
             deliveryQuantityTotal= Long.valueOf(0);
        } else {
             deliveryQuantityTotal = deliveryQuantityRepository.getQuantityByProducts(product);
        }
        deliveryQuantityTotal =deliveryQuantityTotal+deliveryQuantity.getQuantity();
        if (donationsQuantity >= deliveryQuantityTotal) {
            DeliveryQuantity deliveryQuantity1 = deliveryQuantityRepository.save(deliveryQuantity);
            return ResponseEntity.ok(deliveryQuantity1);
        } else throw new ResponseStatusException(HttpStatus.CONFLICT, "Error en las cantidades");


    }
}
