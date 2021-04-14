package no.ntnu.sjakkskjerm.livegame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveGameRepository extends JpaRepository<LiveGame, Long> {

List<LiveGame> findByTournamentIdOrderByTournamentIdAsc(Long tournamentId);

}
