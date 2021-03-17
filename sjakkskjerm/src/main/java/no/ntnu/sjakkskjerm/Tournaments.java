package no.ntnu.sjakkskjerm;

import java.util.ArrayList;
import java.util.List;

/*
 * Class that stores the list of all the tournaments in an ArrayList.
 */
public class Tournaments {

    private List<Tournament> tournamentList;

    /*
     * Get method that returns the list of tournaments.
     */
    public List<Tournament> getTournamentList() {
        if(tournamentList == null) {
            tournamentList = new ArrayList<>();
        }
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }
}