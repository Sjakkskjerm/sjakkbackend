package no.ntnu.sjakkskjerm.tournament.exceptions;

public class AddGameException extends RuntimeException {

    public AddGameException() {
        super("Could not add game. Either tournament does not exist or game already added");
    }
}
