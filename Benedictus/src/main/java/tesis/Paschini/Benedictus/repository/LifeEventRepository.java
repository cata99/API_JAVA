package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import tesis.Paschini.Benedictus.model.LifeEvent;
import tesis.Paschini.Benedictus.model.PersonalInformation;

import java.util.List;
import java.util.Optional;

public interface LifeEventRepository extends JpaRepository<LifeEvent, Long> {

    @Query("select l from LifeEvent l where l.personalInformation =:personalInformation")
    List<LifeEvent> getLifeEventsByUser(@RequestParam("personalInformation") Optional<PersonalInformation> personalInformation);

}
