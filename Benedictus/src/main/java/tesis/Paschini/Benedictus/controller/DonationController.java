package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.Donation;
import tesis.Paschini.Benedictus.repository.DonationRepository;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/donations/")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<Donation> getAllDonation() {
        return donationRepository.findAll();
    }


    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> countDonations() {

        long amount = donationRepository.count();

        Map<String, Object> payload = new HashMap<>();
        payload.put("count", amount
        );

        return ResponseEntity.ok(payload);
    }

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationRepository.save(donation);
    }

    @GetMapping("{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable long id) {
        Donation donation = donationRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(donation);
    }


    @PutMapping("{id}")
    public ResponseEntity<Donation> updateDonation(@PathVariable long id, @RequestBody Donation donation) {
        Donation updateDonation = donationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        if (donation.getPersonalInformation().getId() != null) {
            updateDonation.setPersonalInformation(donation.getPersonalInformation());
        } else
            updateDonation.setPersonalInformation(updateDonation.getPersonalInformation());

        if (donation.getUser().getId() != null) {
            updateDonation.setUser(userRepository.getById(donation.getUser().getId()));
        } else{
            updateDonation.setUser(userRepository.getById(updateDonation.getUser().getId()));
        }

        if (donation.getUpdateDate() != "") {
            updateDonation.setUpdateDate((donation.getUpdateDate()));
        } else
            updateDonation.setUpdateDate(updateDonation.getUpdateDate());

        if (donation.getCreationDate() != "") updateDonation.setCreationDate((donation.getCreationDate()));
        else updateDonation.setCreationDate(updateDonation.getCreationDate());

        if(donation.getInstitution().getId() != null) updateDonation.setInstitution(donation.getInstitution());
        else updateDonation.setInstitution(updateDonation.getInstitution());



        donationRepository.save(updateDonation);
        return ResponseEntity.ok(updateDonation);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteDonation(@PathVariable(value = "id") Long donationId)
            throws ResourceNotFoundException {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + donationId));

        donationRepository.delete(donation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
