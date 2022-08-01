package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.LifeEvent;

import java.util.List;
import java.util.Optional;

public interface LifeEventService {
    LifeEvent saveLifeEvent(LifeEvent lifeEvent);

    List<LifeEvent> getAllLifeEvent();

    Optional<LifeEvent> getLifeEventById(long id);

    LifeEvent updateLifeEvent(LifeEvent updatedLifeEvent);

    void deleteLifeEvent(long id);
}