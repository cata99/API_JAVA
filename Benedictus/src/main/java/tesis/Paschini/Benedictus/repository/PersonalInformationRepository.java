package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.model.PersonalInformation;

import java.util.List;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {

    @Query("from PersonalInformation where id not in (select personalInformation from User)")
    List<PersonalInformation> getPersonalInformation();
}
