package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.models.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
