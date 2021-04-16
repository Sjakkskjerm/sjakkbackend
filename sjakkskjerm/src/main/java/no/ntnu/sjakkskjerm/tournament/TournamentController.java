package no.ntnu.sjakkskjerm.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/tournaments")
@CrossOrigin("*")
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }


    @GetMapping(path = "/")
    public List<Tournament> getTournaments() {
        return tournamentService.getAllTournaments();
    }

    @PostMapping("/addGame")
    public void addGameToTournament(Long tournamentId, Long gameId) {
        this.tournamentService.addGameToTournament(tournamentId, gameId);
    }
    

}
