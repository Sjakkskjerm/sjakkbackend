package no.ntnu.sjakkskjerm.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
     * Method that adds a tournament to the tournament list
     */
    @PostMapping(path = "/createtournament")
    @CrossOrigin("*")
    public void addTournament(@RequestBody Tournament tournament) {
        tournamentService.addTournament(tournament);
        System.out.println(tournament.toString());
    }
    

}
