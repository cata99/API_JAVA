package tesis.Paschini.Benedictus.serviceImpl;

import org.springframework.stereotype.Service;
import tesis.Paschini.Benedictus.exception.ResourceNotFoundException;
import tesis.Paschini.Benedictus.models.User;
import tesis.Paschini.Benedictus.repository.UserRepository;
import tesis.Paschini.Benedictus.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user){
        Optional<User> savedUser = userRepository.findById(user.getId());
        if(savedUser.isPresent()){
            throw new ResourceNotFoundException("User already exist with given email:" +user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User updatedUser){
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
