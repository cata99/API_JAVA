package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.People;
import tesis.Paschini.Benedictus.repository.PeopleRepository;
import tesis.Paschini.Benedictus.service.PeopleService;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService {

    private PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository){
        this.peopleRepository=peopleRepository;
    }

    @Override
    public People savePeople(People people){
        Optional<People> savedPeople = peopleRepository.findById(people.getId());
        if(savedPeople.isPresent()){
            throw new ResourceNotFoundException("People already exist with given email:" +people.getId());
        }
        return peopleRepository.save(people);
    }

    @Override
    public List<People> getAllPeople(){
        return peopleRepository.findAll();
    }

    @Override
    public Optional<People> getPeopleById(long id){
        return peopleRepository.findById(id);
    }

    @Override
    public People updatePeople(People updatedPeople){
        return peopleRepository.save(updatedPeople);
    }

    @Override
    public void deletePeople(long id){
        peopleRepository.deleteById(id);
    }
}
