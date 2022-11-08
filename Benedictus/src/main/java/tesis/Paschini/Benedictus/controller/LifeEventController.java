package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.LifeEvent;
import tesis.Paschini.Benedictus.model.PersonalInformation;
import tesis.Paschini.Benedictus.model.User;
import tesis.Paschini.Benedictus.repository.LifeEventRepository;
import tesis.Paschini.Benedictus.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/life_events/")
public class LifeEventController {
    
    @Autowired
    LifeEventRepository lifeEventRepository;

    @Autowired
    UserRepository userRepository;
    @GetMapping
    public List<LifeEvent> getAllLifeEvents(){
        return lifeEventRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<LifeEvent> getLifeEventById(@PathVariable long id){
        LifeEvent lifeEvent = lifeEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return  ResponseEntity.ok(lifeEvent);
    }

    @GetMapping("user/{id}")
    public List<LifeEvent> getLifeEvents(@PathVariable long id) {

        Optional<User> user = userRepository.findById(id);
        PersonalInformation personalInformation = user.get().getPersonalInformation();
        List<LifeEvent> lifeEvents = lifeEventRepository.getLifeEventsByUser(Optional.ofNullable(personalInformation));
        return lifeEvents;


    }


    @PostMapping
    public LifeEvent createLifeEvent(@RequestBody LifeEvent lifeEvent){
        return lifeEventRepository.save(lifeEvent);
    }

    @PutMapping("{id}")
    public ResponseEntity<LifeEvent> updateLifeEvent(@PathVariable long id, @RequestBody LifeEvent lifeEvent){
        LifeEvent updateLifeEvent = lifeEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        updateLifeEvent.setDate(lifeEvent.getDate());
        updateLifeEvent.setLabel(lifeEvent.getLabel());
        updateLifeEvent.setPersonalInformation(lifeEvent.getPersonalInformation());

        lifeEventRepository.save(updateLifeEvent);

        return ResponseEntity.ok(updateLifeEvent);
    }
}

