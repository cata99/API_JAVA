package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<Delivery> findAll(){
        return deliveryRepository.findAll();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countDeliveries() {

        long amount= deliveryRepository.count();

        Map<String, Object> payload = new HashMap<>();
        payload.put("count", amount
        );

        return ResponseEntity.ok(payload);
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery){
        return deliveryRepository.save(delivery);
    }
}
