package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Unit;

import java.util.List;
import java.util.Optional;

public interface UnitService {
    Unit saveUnit(Unit unit);

    List<Unit> getAllUnit();

    Optional<Unit> getUnitById(long id);

    Unit updateUnit(Unit updatedUnit);

    void deleteUnit(long id);
}