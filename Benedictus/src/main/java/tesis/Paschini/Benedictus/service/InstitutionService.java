package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    Institution saveInstitution(Institution institution);

    List<Institution> getAllInstitution();

    Optional<Institution> getInstitutionById(long id);

    Institution updateInstitution(Institution updatedInstitution);

    void deleteInstitution(long id);
}