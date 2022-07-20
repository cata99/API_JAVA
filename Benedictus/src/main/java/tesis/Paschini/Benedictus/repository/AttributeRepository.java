package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.models.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
