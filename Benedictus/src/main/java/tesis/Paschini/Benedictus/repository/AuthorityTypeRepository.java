package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.models.AuthorityType;

@Repository
public interface AuthorityTypeRepository extends JpaRepository<AuthorityType, Long> {
}
