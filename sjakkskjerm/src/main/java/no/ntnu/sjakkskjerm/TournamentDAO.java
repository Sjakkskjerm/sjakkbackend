package no.ntnu.sjakkskjerm;

import org.springframework.stereotype.Repository;
import no.ntnu.sjakkskjerm.Tournaments;

@Repository
/*
 * Class that creates a list of tournaments
 */
public class TournamentDAO {

    private static Tournaments list = new Tournaments();

    /*
     * TODO add static block with dummies
     * Will be run before that main block
     */
    static {
        //dummies
        //id, startDate, endDate, numberOfRounds, gamesPerRound, tournamentOrganizer
    }

    /*
     * Get method that returns the list
     */
    public static Tournaments getAllTournaments() {
        return list;
    }

    /*
     * Method that adds a tournament to the tournament list
     */
    public void addTournament(Tournament tournament) {
        list.getTournamentList().add(tournament);
    }
}
