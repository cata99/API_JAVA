package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Movement;
import tesis.Paschini.Benedictus.repository.MovementRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Movements")
public class MovementController {

    @Autowired
    private MovementRepository movementRepository;

    @GetMapping
    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement) {
        return movementRepository.save(movement);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movement> getMovementById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("movement not exist with id:" + id));

        return ResponseEntity.ok(movement);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movement> updateMovement( @PathVariable(value = "id" ) Long id , @RequestBody Movement movementDetails) throws ResourceNotFoundException{
        Movement movement= movementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movement not exist with id:" + id));

        movement.setKindOfMovement(movementDetails.getKindOfMovement());
        movement.setDate(movementDetails.getDate());
        movement.setInstitutionId(movementDetails.getInstitutionId());
        movement.setUserId(movementDetails.getUserId());

        final Movement updatedMovement = movementRepository.save(movement);
        return ResponseEntity.ok(updatedMovement);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long movementId) throws ResourceNotFoundException {
        Movement movement= movementRepository.findById(movementId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + movementId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
