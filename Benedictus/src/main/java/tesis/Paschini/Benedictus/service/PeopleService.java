package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.People;

import java.util.List;
import java.util.Optional;

public interface PeopleService {
    People savePeople(People people);

    List<People> getAllPeople();

    Optional<People> getPeopleById(long id);

    People updatePeople(People updatedPeople);

    void deletePeople(long id);
}