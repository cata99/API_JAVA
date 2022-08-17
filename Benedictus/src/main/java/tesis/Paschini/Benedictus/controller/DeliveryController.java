package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.model.Delivery;
import tesis.Paschini.Benedictus.repository.DeliveryRepository;

import java.util.List;

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

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery){
        return deliveryRepository.save(delivery);
    }
}
