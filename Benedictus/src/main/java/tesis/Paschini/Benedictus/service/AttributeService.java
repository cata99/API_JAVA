package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Attribute;

import java.util.List;
import java.util.Optional;

public interface AttributeService {
    Attribute saveAttribute(Attribute attribute);

    List<Attribute> getAllAttribute();

    Optional<Attribute> getAttributeById(long id);

    Attribute updateAttribute(Attribute updatedAttribute);

    void deleteAttribute(long id);
}