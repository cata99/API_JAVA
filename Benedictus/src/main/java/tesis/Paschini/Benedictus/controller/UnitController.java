package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Unit;
import tesis.Paschini.Benedictus.repository.UnitRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Units/")
public class UnitController {

    @Autowired
    private UnitRepository unitRepository;

    @GetMapping
    public List<Unit> getAllUnit() {
        return unitRepository.findAll();
    }

    @PostMapping
    public Unit createAttribute(@RequestBody Unit unit) {
        return unitRepository.save(unit);
    }

    @GetMapping("{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("unit not exist with id:" + id));

        return ResponseEntity.ok(unit);
    }

    @PutMapping("{id}")
    public ResponseEntity<Unit> updateUnit( @PathVariable(value = "id" ) Long id , @RequestBody Unit unitDetails) throws ResourceNotFoundException{
        Unit unit= unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not exist with id:" + id));
        unit.setUnit(unitDetails.getUnit());
        final Unit updatedUnit = unitRepository.save(unit);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteUser (@PathVariable(value = "id") Long unitId) throws ResourceNotFoundException {
        Unit unit= unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + unitId));

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
