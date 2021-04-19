package no.ntnu.sjakkskjerm.livegame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<LiveGame> games = liveGameService.getGamesByTournamentId(id);
        return liveGameService.getGamesByTournamentId(id);
    }
}
