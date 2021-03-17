package no.ntnu.sjakkskjerm;

import org.springframework.stereotype.Repository;

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
    }


}
