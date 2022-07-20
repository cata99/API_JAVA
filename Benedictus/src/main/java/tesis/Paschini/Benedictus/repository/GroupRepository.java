package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
