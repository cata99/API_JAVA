package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Movement;
import tesis.Paschini.Benedictus.service.MovementService;

import java.util.List;

@RestController
@RequestMapping("/api/Movements/")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @GetMapping
    public List<Movement> getAllMovements() {
        return movementService.getAllMovement();
    }

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement) {
        return movementService.saveMovement(movement);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movement> getMovementById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Movement movement = movementService.getMovementById(id)
                .orElseThrow(() -> new ResourceNotFoundException("movement not exist with id:" + id));

        return ResponseEntity.ok(movement);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movement> updateMovement( @PathVariable(value = "id" ) Long id , @RequestBody Movement movementDetails) throws ResourceNotFoundException{
        Movement movement= movementService.getMovementById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movement not exist with id:" + id));

        movement.setKindOfMovement(movementDetails.getKindOfMovement());
        movement.setDate(movementDetails.getDate());
        movement.setInstitutionId(movementDetails.getInstitutionId());
        movement.setUserId(movementDetails.getUserId());

        final Movement updatedMovement = movementService.saveMovement(movement);
        return ResponseEntity.ok(updatedMovement);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovement (@PathVariable(value = "id") Long movementId) throws ResourceNotFoundException {
        movementService.deleteMovement(movementId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
