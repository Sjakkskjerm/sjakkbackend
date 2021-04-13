package no.ntnu.sjakkskjerm.livegame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveGameRepository extends JpaRepository<LiveGame, Long> {
}
