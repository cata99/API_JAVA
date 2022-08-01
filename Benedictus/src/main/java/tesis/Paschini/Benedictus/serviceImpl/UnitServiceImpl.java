package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Unit;
import tesis.Paschini.Benedictus.repository.UnitRepository;
import tesis.Paschini.Benedictus.service.UnitService;

import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    private UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository){
        this.unitRepository = unitRepository;
    }

    @Override
    public Unit saveUnit(Unit unit){
        Optional<Unit> savedUnit = unitRepository.findById(unit.getId());
        if(savedUnit.isPresent()){
            throw new ResourceNotFoundException("Unit already exist with given email:" +unit.getId());
        }
        return unitRepository.save(unit);
    }

    @Override
    public List<Unit> getAllUnit(){
        return unitRepository.findAll();
    }

    @Override
    public Optional<Unit> getUnitById(long id){
        return unitRepository.findById(id);
    }

    @Override
    public Unit updateUnit(Unit updatedUnit){
        return unitRepository.save(updatedUnit);
    }

    @Override
    public void deleteUnit(long id){
        unitRepository.deleteById(id);
    }
}
