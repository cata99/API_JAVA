package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.model.LifeEvent;
import tesis.Paschini.Benedictus.repository.LifeEventRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/life_events/")
public class LifeEventController {
    
    @Autowired
    LifeEventRepository lifeEventRepository;

    @GetMapping
    public List<LifeEvent> getAllLifeEvents(){
        return lifeEventRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<LifeEvent> getLifeEventById(@PathVariable long id){
        LifeEvent lifeEvent = lifeEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        return  ResponseEntity.ok(lifeEvent);
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

