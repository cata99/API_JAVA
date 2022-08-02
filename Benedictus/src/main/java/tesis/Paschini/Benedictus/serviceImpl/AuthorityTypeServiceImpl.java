package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.AuthorityType;
import tesis.Paschini.Benedictus.repository.AuthorityTypeRepository;
import tesis.Paschini.Benedictus.service.AuthorityTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityTypeServiceImpl implements AuthorityTypeService {

    private AuthorityTypeRepository authorityTypeRepository;

    public AuthorityTypeServiceImpl(AuthorityTypeRepository authorityTypeRepository){
        this.authorityTypeRepository=authorityTypeRepository;
    }

    @Override
    public AuthorityType saveAuthorityType(AuthorityType authorityType){
        Optional<AuthorityType> savedAuthorityType = authorityTypeRepository.findById(authorityType.getId());
        if(savedAuthorityType.isPresent()){
            throw new ResourceNotFoundException("AuthorityType already exist with given email:" + authorityType.getId());
        }
        return authorityTypeRepository.save(authorityType);
    }

    @Override
    public List<AuthorityType> getAllAuthorityType(){
        return authorityTypeRepository.findAll();
    }

    @Override
    public Optional<AuthorityType> getAuthorityTypeById(long id){
        return authorityTypeRepository.findById(id);
    }

    @Override
    public AuthorityType updateAuthorityType(AuthorityType updatedAuthorityType){
        return authorityTypeRepository.save(updatedAuthorityType);
    }

    @Override
    public void deleteAuthorityType(long id){
        authorityTypeRepository.deleteById(id);
    }
}