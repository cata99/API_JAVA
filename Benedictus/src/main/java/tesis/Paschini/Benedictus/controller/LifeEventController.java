package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.LifeEvent;
import tesis.Paschini.Benedictus.repository.LifeEventRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/LifeEvents/")
public class LifeEventController {

    @Autowired
    private LifeEventRepository lifeEventRepository;

    @GetMapping
    public List<LifeEvent> getAllLifeEvents() {
        return lifeEventRepository.findAll();
    }

    @PostMapping
    public LifeEvent createAttribute(@RequestBody LifeEvent lifeEvent) {
        return lifeEventRepository.save(lifeEvent);
    }

    @GetMapping("{id}")
    public ResponseEntity<LifeEvent> getLifeEventById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        LifeEvent lifeEvent = lifeEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lifeEvent not exist with id:" + id));

        return ResponseEntity.ok(lifeEvent);
    }

    @PutMapping("{id}")
    public ResponseEntity<LifeEvent> updateLifeEvent( @PathVariable(value = "id" ) Long id , @RequestBody LifeEvent lifeEventDetails) throws ResourceNotFoundException{
        LifeEvent lifeEvent= lifeEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LifeEvent not exist with id:" + id));

        lifeEvent.setDate(lifeEvent.getDate());
        lifeEvent.setLabel(lifeEvent.getLabel());
        lifeEvent.setLabel(lifeEvent.getLabel());

        final LifeEvent updatedLifeEvent = lifeEventRepository.save(lifeEvent);
        return ResponseEntity.ok(updatedLifeEvent);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long lifeEventId) throws ResourceNotFoundException {
        LifeEvent lifeEvent= lifeEventRepository.findById(lifeEventId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + lifeEventId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
