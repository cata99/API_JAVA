package tesis.Paschini.Benedictus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.PersonalInformation;
import tesis.Paschini.Benedictus.repository.PersonalInformationRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/personal_information/")
public class PersonalInformationController {

    @Autowired
    PersonalInformationRepository personalInformationRepository;

    @GetMapping
    public List<PersonalInformation> getAllPersonalInformation(){
        return personalInformationRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonalInformation> getPersonalInformationById(@PathVariable long id){
        PersonalInformation personalInformation = personalInformationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        return ResponseEntity.ok(personalInformation);
    }

    @PostMapping
    public PersonalInformation createPersonalInformation(@PathVariable PersonalInformation personalInformation){
        return personalInformationRepository.save(personalInformation);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePersonalInformation(@PathVariable long id, @RequestBody PersonalInformation personalInformation){
        PersonalInformation updatePersonalInformation = personalInformationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updatePersonalInformation.setFirstName(personalInformation.getFirstName());
        updatePersonalInformation.setLastName(personalInformation.getLastName());
        updatePersonalInformation.setEmail(personalInformation.getEmail());
        updatePersonalInformation.setGender(personalInformation.getGender());
        updatePersonalInformation.setPhone(personalInformation.getPhone());
        updatePersonalInformation.setIdentificationNumber(personalInformation.getIdentificationNumber());

        personalInformationRepository.save(updatePersonalInformation);

        return ResponseEntity.ok(updatePersonalInformation);
    }
}
