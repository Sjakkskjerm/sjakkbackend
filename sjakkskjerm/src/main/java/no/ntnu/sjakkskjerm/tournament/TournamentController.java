package no.ntnu.sjakkskjerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Import the already defined tournament classes to use here
import no.ntnu.sjakkskjerm.Tournament;
import no.ntnu.sjakkskjerm.Tournaments;
import no.ntnu.sjakkskjerm.TournamentDAO;

//Importing getAllTournaments() method directly as a temporary fix
import static no.ntnu.sjakkskjerm.TournamentDAO.getAllTournaments;

/*
 * REST controller class
 */
@RestController
@RequestMapping(path = "/tournaments")
public class TournamentController {

    @Autowired
    private TournamentDAO tournamentDAO;

    /*
     * Get method to get a list of the tournaments
     */
    @GetMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Tournaments getTournaments() {
        return getAllTournaments();
    }
    

}
