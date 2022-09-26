package tesis.Paschini.Benedictus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}