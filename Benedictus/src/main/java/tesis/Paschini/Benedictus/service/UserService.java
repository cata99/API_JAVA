package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    Optional<User> getUserById(long id);

    User updateUser(User updatedUser);

    void deleteUser(long id);
}