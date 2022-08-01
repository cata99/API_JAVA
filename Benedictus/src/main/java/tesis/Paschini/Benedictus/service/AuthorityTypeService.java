package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.AuthorityType;

import java.util.List;
import java.util.Optional;

public interface AuthorityTypeService {
    AuthorityType saveAuthorityType(AuthorityType authorityType);

    List<AuthorityType> getAllAuthorityType();

    Optional<AuthorityType> getAuthorityTypeById(long id);

    AuthorityType updateAuthorityType(AuthorityType updatedAuthorityType);

    void deleteAuthorityType(long id);
}