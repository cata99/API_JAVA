package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.LifeEvent;
import tesis.Paschini.Benedictus.service.LifeEventService;

import java.util.List;

@RestController
@RequestMapping("/api/LifeEvents/")
public class LifeEventController {

    @Autowired
    private LifeEventService lifeEventService;

    @GetMapping
    public List<LifeEvent> getAllLifeEvents() {
        return lifeEventService.getAllLifeEvent();
    }

    @PostMapping
    public LifeEvent createLiveEvent(@RequestBody LifeEvent lifeEvent) {
        return lifeEventService.saveLifeEvent(lifeEvent);
    }

    @GetMapping("{id}")
    public ResponseEntity<LifeEvent> getLifeEventById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        LifeEvent lifeEvent = lifeEventService.getLifeEventById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lifeEvent not exist with id:" + id));

        return ResponseEntity.ok(lifeEvent);
    }

    @PutMapping("{id}")
    public ResponseEntity<LifeEvent> updateLifeEvent( @PathVariable(value = "id" ) Long id , @RequestBody LifeEvent lifeEventDetails) throws ResourceNotFoundException{
        LifeEvent lifeEvent= lifeEventService.getLifeEventById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LifeEvent not exist with id:" + id));

        lifeEvent.setDate(lifeEvent.getDate());
        lifeEvent.setLabel(lifeEvent.getLabel());
        lifeEvent.setLabel(lifeEvent.getLabel());

        final LifeEvent updatedLifeEvent = lifeEventService.saveLifeEvent(lifeEvent);
        return ResponseEntity.ok(updatedLifeEvent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLiveEvent (@PathVariable(value = "id") Long LiveEventId) throws ResourceNotFoundException {
        lifeEventService.deleteLifeEvent(LiveEventId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
