package no.ntnu.sjakkskjerm.livegame;

import no.ntnu.sjakkskjerm.livegame.exceptions.EmptyPGNException;
import no.ntnu.sjakkskjerm.livegame.exceptions.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path= "api/games")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LiveGameController {

    private final LiveGameService liveGameService;

    @Autowired
    public LiveGameController(LiveGameService liveGameService) {
        this.liveGameService = liveGameService;
    }

    @GetMapping
    public List<LiveGame> getGames() {
        return liveGameService.getGames();
    }

    @GetMapping("/")
    public ResponseEntity<LiveGame> getGame(@RequestParam String id) {
        LiveGame game = liveGameService.getGame(id);
        if (game == null) {
            throw new GameNotFoundException(id);
        }
        return ResponseEntity.ok(game);
    }

    @GetMapping("/gamesfortournament/")
    public List<LiveGame> getGamesByTournamentId(@RequestParam(name = "tournamentid") Long id) {
        return liveGameService.getGamesByTournamentId(id);
    }

    @PutMapping(path = "/updategame", value = "/updategame")
    public ResponseEntity<LiveGame> updateGame(@RequestParam(name = "gameid") String gameid, @RequestBody List<String> pgn) {
        if (pgn.isEmpty()) {
            throw new EmptyPGNException();
        }
        LiveGame game = liveGameService.updateGame(gameid, pgn);
        if (game == null) {
            throw new GameNotFoundException(gameid);
        }
        return ResponseEntity.ok(game);
    }
}
