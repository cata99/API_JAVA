package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.LifeEvent;
import tesis.Paschini.Benedictus.repository.LifeEventRepository;
import tesis.Paschini.Benedictus.service.LifeEventService;

import java.util.List;
import java.util.Optional;

@Service
public class LifeEventServiceImpl implements LifeEventService {

    private LifeEventRepository lifeEventRepository;

    public LifeEventServiceImpl(LifeEventRepository lifeEventRepository){
        this.lifeEventRepository=lifeEventRepository;
    }

    @Override
    public LifeEvent saveLifeEvent(LifeEvent lifeEvent){
        Optional<LifeEvent> savedLifeEvent = lifeEventRepository.findById(lifeEvent.getId());
        if(savedLifeEvent.isPresent()){
            throw new ResourceNotFoundException("LifeEvent already exist with given email:" +lifeEvent.getId());
        }
        return lifeEventRepository.save(lifeEvent);
    }

    @Override
    public List<LifeEvent> getAllLifeEvent(){
        return lifeEventRepository.findAll();
    }

    @Override
    public Optional<LifeEvent> getLifeEventById(long id){
        return lifeEventRepository.findById(id);
    }

    @Override
    public LifeEvent updateLifeEvent(LifeEvent updatedLifeEvent){
        return lifeEventRepository.save(updatedLifeEvent);
    }

    @Override
    public void deleteLifeEvent(long id){
        lifeEventRepository.deleteById(id);
    }
}
