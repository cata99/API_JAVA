package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tesis.Paschini.Benedictus.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
