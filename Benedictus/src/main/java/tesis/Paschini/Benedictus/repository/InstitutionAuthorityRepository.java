package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.Institution;
import tesis.Paschini.Benedictus.model.InstitutionAuthority;

import java.util.List;
import java.util.Optional;

public interface InstitutionAuthorityRepository  extends JpaRepository<InstitutionAuthority, Long> {

    @Query("from InstitutionAuthority i where i.institution = :institution")
    List<InstitutionAuthority> getAuthorityByInstitution(@RequestParam("institution") Optional<Institution> institution);
}
