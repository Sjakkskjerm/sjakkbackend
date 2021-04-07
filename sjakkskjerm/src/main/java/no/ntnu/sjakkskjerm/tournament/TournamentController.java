package no.ntnu.sjakkskjerm.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Import the already defined tournament classes to use here


/*
 * REST controller class
 */
@RestController
@RequestMapping(path = "api/tournaments")
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    /*
     * Get method to get a list of the tournaments
     */
    @GetMapping(path = "/")
    @CrossOrigin("*")
    public List<Tournament> getTournaments() {
        return tournamentService.getAllTournaments();
    }
    

}
