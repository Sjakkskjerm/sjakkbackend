package no.ntnu.sjakkskjerm.auth.repositories;

import no.ntnu.sjakkskjerm.auth.models.Role;
import no.ntnu.sjakkskjerm.auth.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
