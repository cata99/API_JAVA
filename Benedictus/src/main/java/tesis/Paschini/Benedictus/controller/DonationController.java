package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.model.Donation;
import tesis.Paschini.Benedictus.repository.DonationRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/donation/")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

    public List<Donation> getAllDonation(){
        return donationRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Donation> createEmployee(@RequestBody Donation donationDetails) {
        Donation donation = donationRepository.save(donationDetails);
        return ResponseEntity.ok(donationDetails);
    }
}
