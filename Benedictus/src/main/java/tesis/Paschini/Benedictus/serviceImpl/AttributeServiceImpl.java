package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.Attribute;
import tesis.Paschini.Benedictus.repository.AttributeRepository;
import tesis.Paschini.Benedictus.service.AttributeService;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService {

    private AttributeRepository attributeRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository){
        this.attributeRepository=attributeRepository;
    }

    @Override
    public Attribute saveAttribute(Attribute attribute){
        Optional<Attribute> savedAttribute = attributeRepository.findById(Attribute.getId());
        if(savedAttribute.isPresent()){
            throw new ResourceNotFoundException("Attribute already exist with given email:" +Attribute.getId());
        }
        return attributeRepository.save(attribute);
    }

    @Override
    public List<Attribute> getAllAttribute(){
        return attributeRepository.findAll();
    }

    @Override
    public Optional<Attribute> getAttributeById(long id){
        return attributeRepository.findById(id);
    }

    @Override
    public Attribute updateAttribute(Attribute updatedAttribute){
        return attributeRepository.save(updatedAttribute);
    }

    @Override
    public void deleteAttribute(long id){
        attributeRepository.deleteById(id);
    }
}
