package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Disease;
import tesis.Paschini.Benedictus.repository.DiseaseRepository;
import tesis.Paschini.Benedictus.service.DiseaseService;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    private DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository){
        this.diseaseRepository=diseaseRepository;
    }

    @Override
    public Disease saveDisease(Disease disease){
        Optional<Disease> savedDisease = diseaseRepository.findById(disease.getId());
        if(savedDisease.isPresent()){
            throw new ResourceNotFoundException("Disease already exist with given email:" + disease.getId());
        }
        return diseaseRepository.save(disease);
    }

    @Override
    public List<Disease> getAllDisease(){
        return diseaseRepository.findAll();
    }

    @Override
    public Optional<Disease> getDiseaseById(long id){
        return diseaseRepository.findById(id);
    }

    @Override
    public Disease updateDisease(Disease updatedDisease){
        return diseaseRepository.save(updatedDisease);
    }

    @Override
    public void deleteDisease(long id){
        diseaseRepository.deleteById(id);
    }
}
