package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tesis.Paschini.Benedictus.model.Disease;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    @Query("select d.label from Disease d")
    List<String> getLabels();
}
