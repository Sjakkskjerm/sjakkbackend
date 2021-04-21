package no.ntnu.sjakkskjerm.livegame.exceptions;

public class EmptyPGNException extends RuntimeException {

    public EmptyPGNException() {
        super("PGN contains no information, it can't be empty.");
    }
}
