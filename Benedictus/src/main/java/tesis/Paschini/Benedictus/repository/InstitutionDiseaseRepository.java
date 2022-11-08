package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.Institution;
import tesis.Paschini.Benedictus.model.InstitutionDisease;

import java.util.List;
import java.util.Optional;

public interface InstitutionDiseaseRepository  extends JpaRepository<InstitutionDisease, Long> {


    @Query("from InstitutionDisease i where i.institution = :institution")
    List<InstitutionDisease> getDiseasesByInstitution(@RequestParam("institution") Optional<Institution> institution);
}
