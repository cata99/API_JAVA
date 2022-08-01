package tesis.Paschini.Benedictus.service;
import tesis.Paschini.Benedictus.models.Authority;

import java.util.List;
import java.util.Optional;

public interface AuthorityService {
    Authority saveAuthority(Authority authority);

    List<Authority> getAllAuthority();

    Optional<Authority> getAuthorityById(long id);

    Authority updateAuthority(Authority updatedAuthority);

    void deleteAuthority(long id);
}