package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.models.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
