package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Role;
import tesis.Paschini.Benedictus.repository.RoleRepository;
import tesis.Paschini.Benedictus.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @Override
    public Role saveRole(Role role){
        Optional<Role> savedRole = roleRepository.findById(role.getId());
        if(savedRole.isPresent()){
            throw new ResourceNotFoundException("Role already exist with given email:" +role.getId());
        }
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(long id){
        return roleRepository.findById(id);
    }

    @Override
    public Role updateRole(Role updatedRole){
        return roleRepository.save(updatedRole);
    }

    @Override
    public void deleteRole(long id){
        roleRepository.deleteById(id);
    }
}
