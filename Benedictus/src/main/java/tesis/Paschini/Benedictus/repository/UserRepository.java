package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.PersonalInformation;
import tesis.Paschini.Benedictus.model.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
    @Query("select u from User u where u.personalInformation = :personalInformation")
    User findUserByPersonalInformation(@RequestParam("personalInformation") Optional<PersonalInformation> personalInformation);

}
