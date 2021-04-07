package no.ntnu.sjakkskjerm.tournament;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*
 * Class that creates a list of tournaments
 */
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    /*
     * Get method that returns the list
     */
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    /*
     * Method that adds a tournament to the tournament list
     */
    public void addTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }
}
