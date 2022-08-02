package tesis.Paschini.Benedictus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Unit;
import tesis.Paschini.Benedictus.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("/api/Units/")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<Unit> getAllUnit() {
        return unitService.getAllUnit();
    }

    @PostMapping
    public Unit createAttribute(@RequestBody Unit unit) {
        return unitService.saveUnit(unit);
    }

    @GetMapping("{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable (value = "id")long id) throws ResourceNotFoundException {
        Unit unit = unitService.getUnitById(id)
                .orElseThrow(() -> new ResourceNotFoundException("unit not exist with id:" + id));

        return ResponseEntity.ok(unit);
    }

    @PutMapping("{id}")
    public ResponseEntity<Unit> updateUnit( @PathVariable(value = "id" ) Long id , @RequestBody Unit unitDetails) throws ResourceNotFoundException{
        Unit unit= unitService.getUnitById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not exist with id:" + id));
        unit.setUnit(unitDetails.getUnit());
        final Unit updatedUnit = unitService.updateUnit(unit);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUnit (@PathVariable(value = "id") Long unitId) throws ResourceNotFoundException {
        unitService.deleteUnit(unitId);

        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }

}
