package tesis.Paschini.Benedictus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tesis.Paschini.Benedictus.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE username=:username")
    User findByUsername(@Param("username") String username);


}