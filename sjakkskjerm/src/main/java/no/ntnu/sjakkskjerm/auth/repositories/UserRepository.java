package no.ntnu.sjakkskjerm.auth.repositories;

import no.ntnu.sjakkskjerm.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

    @Transactional
    @Modifying
    @Query(value = "update user_role set role_role_id = ?1 where user_user_id = ?2 ", nativeQuery = true)
    void changeRole(int roleId, int userId);
}
