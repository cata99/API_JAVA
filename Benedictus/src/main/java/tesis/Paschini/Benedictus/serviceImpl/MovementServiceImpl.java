package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Movement;
import tesis.Paschini.Benedictus.repository.MovementRepository;
import tesis.Paschini.Benedictus.service.MovementService;

import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements MovementService {

    private MovementRepository movementRepository;

    public MovementServiceImpl(MovementRepository movementRepository){
        this.movementRepository=movementRepository;
    }

    @Override
    public Movement saveMovement(Movement movement){
        Optional<Movement> savedMovement = movementRepository.findById(movement.getId());
        if(savedMovement.isPresent()){
            throw new ResourceNotFoundException("Movement already exist with given email:" +movement.getId());
        }
        return movementRepository.save(movement);
    }

    @Override
    public List<Movement> getAllMovement(){
        return movementRepository.findAll();
    }

    @Override
    public Optional<Movement> getMovementById(long id){
        return movementRepository.findById(id);
    }

    @Override
    public Movement updateMovement(Movement updatedMovement){
        return movementRepository.save(updatedMovement);
    }

    @Override
    public void deleteMovement(long id){
        movementRepository.deleteById(id);
    }
}
