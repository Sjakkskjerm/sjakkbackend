package no.ntnu.sjakkskjerm.livegame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/{id}")
    public ResponseEntity<LiveGame> getGame(HttpServletResponse response, @PathVariable String id) {
        LiveGame game = liveGameService.getGame(id);
        if (game == null) {
            response.setStatus(404);
            return null;
        }
        return ResponseEntity.ok(game);
    }

    @GetMapping("/gamesfortournament/{id}")
    public List<LiveGame> getGamesByTournamentId(@PathVariable Long id) {
        return liveGameService.getGamesByTournamentId(id);
    }

    @PostMapping("/updategame/")
    public ResponseEntity<LiveGame> updateGame(@RequestParam(name = "gameid") String gameid, @RequestParam(name = "pgn") List<String> pgn) {
        if (gameid == null || pgn == null || pgn.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        LiveGame game = liveGameService.updateGame(gameid, pgn);
        if (game == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(null);
    }
}
