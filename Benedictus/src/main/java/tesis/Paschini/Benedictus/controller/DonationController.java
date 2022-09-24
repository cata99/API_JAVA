package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.model.Donation;
import tesis.Paschini.Benedictus.repository.DonationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/donations/")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

    public List<Donation> getAllDonation(){
        return donationRepository.findAll();
    }
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countDonations() {

        long amount= donationRepository.count();

        Map<String, Object> payload = new HashMap<>();
        payload.put("count", amount
        );

        return ResponseEntity.ok(payload);
    }

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationRepository.save(donation);
    }
}
