package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.tournament.exceptions.AddGameException;
import no.ntnu.sjakkskjerm.tournament.exceptions.TournamentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @PostMapping("/addgame")
    @ResponseBody
    public ResponseEntity<String> addGameToTournament(@RequestParam(name = "tournamentid") Long tournamentId, @RequestParam(name = "gameid") String gameId) {
        String newid = this.tournamentService.addGameToTournament(tournamentId, gameId);
        if (newid == null) {
            throw new AddGameException();
        }
        return ResponseEntity.ok(newid);
    }

    @PostMapping("/setgamesperround")
    public ResponseEntity<Tournament> setGamesPerRound(@RequestParam(name= "tournamentid") long tournamentId, @RequestParam(name = "gamesperround") int numberOfGames) {
        Tournament updatedTournament = this.tournamentService.setGamesPerRound(tournamentId, numberOfGames);
        if (updatedTournament == null) {
            throw new TournamentNotFoundException(tournamentId);
        }
        return ResponseEntity.ok(updatedTournament);
    }

    @PostMapping("/setnumberofrounds")
    public ResponseEntity<Tournament> setNumberOfRounds(@RequestParam(name = "tournamentid") long tournamentid, @RequestParam(name = "numberofrounds") int numberOfRounds) {
        Tournament updatedTournament = this.tournamentService.setNumberOfRounds(tournamentid, numberOfRounds);
        if (updatedTournament == null) {
            throw new TournamentNotFoundException(tournamentid);
        }
        return ResponseEntity.ok(updatedTournament);
    }
}
