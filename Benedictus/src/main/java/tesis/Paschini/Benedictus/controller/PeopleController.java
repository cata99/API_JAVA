package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.People;
import tesis.Paschini.Benedictus.repository.PeopleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/People/")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    @PostMapping
    public People createAttribute(@RequestBody People people) {
        return peopleRepository.save(people);
    }

    @GetMapping("{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        People people = peopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("people not exist with id:" + id));

        return ResponseEntity.ok(people);
    }

    @PutMapping("{id}")
    public ResponseEntity<People> updatePeople( @PathVariable(value = "id" ) Long id , @RequestBody People peopleDetails) throws ResourceNotFoundException{
        People people= peopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("People not exist with id:" + id));

        people.setEmail(peopleDetails.getEmail());
        people.setFirstName(peopleDetails.getFirstName());
        people.setLastName(peopleDetails.getLastName());
        people.setGender(peopleDetails.getGender());
        people.setPhone(peopleDetails.getPhone());
        people.setIdentificationNumber(peopleDetails.getIdentificationNumber());

        final People updatedPeople = peopleRepository.save(people);
        return ResponseEntity.ok(updatedPeople);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long peopleId) throws ResourceNotFoundException {
        People people= peopleRepository.findById(peopleId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + peopleId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
