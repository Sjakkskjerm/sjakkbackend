package no.ntnu.sjakkskjerm;

import java.util.ArrayList;
import java.util.List;

/*
 * Klasse som lagrer listen av alle turneringer i an ArrayList.
 */
public class Tournaments {

    private List<Tournament> tournamentList;

    /*
     * Get metode som returnerer listen av turneringer
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
