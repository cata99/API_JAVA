package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Authority;
import tesis.Paschini.Benedictus.repository.AuthorityRepository;
import tesis.Paschini.Benedictus.service.AuthorityService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository){
        this.authorityRepository=authorityRepository;
    }

    @Override
    public Authority saveAuthority(Authority authority){
        Optional<Authority> savedAuthority = authorityRepository.findById(authority.getId());
        if(savedAuthority.isPresent()){
            throw new ResourceNotFoundException("Authority already exist with given email:" + authority.getId());
        }
        return authorityRepository.save(authority);
    }

    @Override
    public List<Authority> getAllAuthority(){
        return authorityRepository.findAll();
    }

    @Override
    public Optional<Authority> getAuthorityById(long id){
        return authorityRepository.findById(id);
    }

    @Override
    public Authority updateAuthority(Authority updatedAuthority){
        return authorityRepository.save(updatedAuthority);
    }

    @Override
    public void deleteAuthority(long id){
        authorityRepository.deleteById(id);
    }
}
