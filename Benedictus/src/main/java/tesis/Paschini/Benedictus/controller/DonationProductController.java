package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.DonationProduct;
import tesis.Paschini.Benedictus.repository.DonationProductRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/donations_products/")
public class DonationProductController {

    @Autowired
    DonationProductRepository donationProductRepository;

    @GetMapping
    public List<DonationProduct> getAllDonationProducts(){
        return donationProductRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity getDonationProductById(@PathVariable long id ){
        DonationProduct donationProduct = donationProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(donationProduct);
    }

    @PostMapping
    public DonationProduct createDonationProduct(@RequestBody DonationProduct donationProduct){
        return donationProductRepository.save(donationProduct);
    }

    @PutMapping("{id}")
    public ResponseEntity updateDonationProduct(@PathVariable long id, @RequestBody DonationProduct donationProduct){
        DonationProduct updateDonationProduct = donationProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateDonationProduct.setDonation(donationProduct.getDonation());
        updateDonationProduct.setProduct((donationProduct.getProduct()));
        updateDonationProduct.setQuantity(donationProduct.getQuantity());

        donationProductRepository.save(updateDonationProduct);

        return ResponseEntity.ok(updateDonationProduct);
    }
}
