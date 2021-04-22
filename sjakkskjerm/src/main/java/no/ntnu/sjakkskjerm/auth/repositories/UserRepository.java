package no.ntnu.sjakkskjerm.auth.repositories;

import no.ntnu.sjakkskjerm.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    //Optional<User> findByUserId(Long userId);
    List<User> findByUserId(Long userId);

    //For checking if user already exists by either username or email.
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String username);
}
