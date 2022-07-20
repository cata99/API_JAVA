package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.models.LifeEvent;

@Repository
public interface LifeEventRepository extends JpaRepository<LifeEvent, Long> {
}
