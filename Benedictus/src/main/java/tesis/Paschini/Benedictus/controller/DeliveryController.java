package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Delivery;
import tesis.Paschini.Benedictus.repository.DeliveryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/deliveries/")
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @GetMapping
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countDeliveries() {

        long amount = deliveryRepository.count();

        Map<String, Object> payload = new HashMap<>();
        payload.put("count", amount
        );

        return ResponseEntity.ok(payload);
    }

    @GetMapping("{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable long id) {
        Delivery delivery = deliveryRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(delivery);
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @PutMapping("{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable long id, @RequestBody Delivery delivery) {
        Delivery updateDelivery = deliveryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));


        if (delivery.getDate() != null)
            updateDelivery.setDate((delivery.getDate()));
        else
            updateDelivery.setDate(updateDelivery.getDate());
        if (delivery.getInstitution().getId() != null) {
            updateDelivery.setInstitution((delivery.getInstitution()));
        } else {
            updateDelivery.setInstitution(updateDelivery.getInstitution());
        }
        if (delivery.getUser().getId() != null) {
            updateDelivery.setUser(delivery.getUser());
        } else {
            updateDelivery.setUser(updateDelivery.getUser());
        }


        deliveryRepository.save(updateDelivery);

        return ResponseEntity.ok(updateDelivery);
    }
}
