package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Donation;
import tesis.Paschini.Benedictus.model.DonationProduct;
import tesis.Paschini.Benedictus.repository.DonationProductRepository;
import tesis.Paschini.Benedictus.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/donations_products/")
public class DonationProductController {

    @Autowired
    DonationProductRepository donationProductRepository;

    @Autowired
    DonationRepository donationRepository;

    @GetMapping
    public List<DonationProduct> getAllDonationProducts(){
        return donationProductRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity getDonationProductById(@PathVariable long id ){
        DonationProduct donationProduct = donationProductRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(donationProduct);
    }

    @GetMapping("products/{id}")
    public List<DonationProduct> getProducts(@PathVariable long id){

        Optional<Donation> donation = donationRepository.findById(id);
        return donationProductRepository.getProductsByDonation(donation);


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
