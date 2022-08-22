package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tesis.Paschini.Benedictus.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
