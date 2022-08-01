package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseService {
    Disease saveDisease(Disease disease);

    List<Disease> getAllDisease();

    Optional<Disease> getDiseaseById(long id);

    Disease updateDisease(Disease updatedDisease);

    void deleteDisease(long id);
}