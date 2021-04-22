package no.ntnu.sjakkskjerm.livegame.exceptions;

public class GameNotFoundException extends RuntimeException{

    public GameNotFoundException(String id) {
        super("Could not find game " + id);
    }
}
