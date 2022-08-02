package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.People;
import tesis.Paschini.Benedictus.service.PeopleService;

import java.util.List;

@RestController
@RequestMapping("/api/People/")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public List<People> getAllPeople() {
        return peopleService.getAllPeople();
    }

    @PostMapping
    public People createAttribute(@RequestBody People people) {
        return peopleService.savePeople(people);
    }

    @GetMapping("{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        People people = peopleService.getPeopleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("people not exist with id:" + id));

        return ResponseEntity.ok(people);
    }

    @PutMapping("{id}")
    public ResponseEntity<People> updatePeople( @PathVariable(value = "id" ) Long id , @RequestBody People peopleDetails) throws ResourceNotFoundException{
        People people= peopleService.getPeopleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("People not exist with id:" + id));

        people.setEmail(peopleDetails.getEmail());
        people.setFirstName(peopleDetails.getFirstName());
        people.setLastName(peopleDetails.getLastName());
        people.setGender(peopleDetails.getGender());
        people.setPhone(peopleDetails.getPhone());
        people.setIdentificationNumber(peopleDetails.getIdentificationNumber());

        final People updatedPeople = peopleService.savePeople(people);
        return ResponseEntity.ok(updatedPeople);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePeople (@PathVariable(value = "id") Long peopleId) throws ResourceNotFoundException {
        peopleService.deletePeople(peopleId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
