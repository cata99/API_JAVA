package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Institution;
import tesis.Paschini.Benedictus.repository.InstitutionRepository;
import tesis.Paschini.Benedictus.service.InstitutionService;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository){
        this.institutionRepository=institutionRepository;
    }

    @Override
    public Institution saveInstitution(Institution institution){
        Optional<Institution> savedInstitution = institutionRepository.findById(institution.getId());
        if(savedInstitution.isPresent()){
            throw new ResourceNotFoundException("Institution already exist with given email:" +institution.getId());
        }
        return institutionRepository.save(institution);
    }

    @Override
    public List<Institution> getAllInstitution(){
        return institutionRepository.findAll();
    }

    @Override
    public Optional<Institution> getInstitutionById(long id){
        return institutionRepository.findById(id);
    }

    @Override
    public Institution updateInstitution(Institution updatedInstitution){
        return institutionRepository.save(updatedInstitution);
    }

    @Override
    public void deleteInstitution(long id){
        institutionRepository.deleteById(id);
    }
}
