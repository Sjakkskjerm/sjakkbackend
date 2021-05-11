package no.ntnu.sjakkskjerm.tournament.exceptions;

public class TournamentNotFoundException extends RuntimeException {
    public TournamentNotFoundException(long tournamentId) {
        super("Tournamnet " + tournamentId + " does not exist");
    }
}
