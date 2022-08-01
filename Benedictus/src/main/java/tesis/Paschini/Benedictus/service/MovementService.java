package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Movement;

import java.util.List;
import java.util.Optional;

public interface MovementService {
    Movement saveMovement(Movement movement);

    List<Movement> getAllMovement();

    Optional<Movement> getMovementById(long id);

    Movement updateMovement(Movement updatedMovement);

    void deleteMovement(long id);
}