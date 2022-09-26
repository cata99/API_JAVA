package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tesis.Paschini.Benedictus.model.PersonalInformation;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {

    @Query("FROM User WHERE email=:email")
    PersonalInformation findByEmail(@Param("email") String email);
}
