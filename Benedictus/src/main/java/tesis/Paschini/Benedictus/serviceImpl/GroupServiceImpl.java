package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Group;
import tesis.Paschini.Benedictus.repository.GroupRepository;
import tesis.Paschini.Benedictus.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }

    @Override
    public Group saveGroup(Group group){
        Optional<Group> savedGroup = groupRepository.findById(group.getId());
        if(savedGroup.isPresent()){
            throw new ResourceNotFoundException("Group already exist with given email:" +group.getId());
        }
        return groupRepository.save(group);
    }

    @Override
    public List<Group> getAllGroup(){
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> getGroupById(long id){
        return groupRepository.findById(id);
    }

    @Override
    public Group updateGroup(Group updatedGroup){
        return groupRepository.save(updatedGroup);
    }

    @Override
    public void deleteGroup(long id){
        groupRepository.deleteById(id);
    }
}
