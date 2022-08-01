package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role saveRole(Role role);

    List<Role> getAllRole();

    Optional<Role> getRoleById(long id);

    Role updateRole(Role updatedRole);

    void deleteRole(long id);
}