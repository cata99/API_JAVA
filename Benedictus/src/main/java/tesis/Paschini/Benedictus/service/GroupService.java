package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Group saveGroup(Group group);

    List<Group> getAllGroup();

    Optional<Group> getGroupById(long id);

    Group updateGroup(Group updatedGroup);

    void deleteGroup(long id);
}