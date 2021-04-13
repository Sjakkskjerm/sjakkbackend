package no.ntnu.sjakkskjerm.livegame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path= "api/games")
//@CrossOrigin("*")
public class LiveGameController {

    private final LiveGameService liveGameService;

    @Autowired
    public LiveGameController(LiveGameService liveGameService) {
        this.liveGameService = liveGameService;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<LiveGame> getGames() {
        return liveGameService.getGames();
    }
//    @GetMapping
//    public ResponseEntity<LiveGame> getGame(@RequestParam("id")Long gameId) {
//        LiveGame game = liveGameService.getGame(gameId);
//        if (game == null) {
//            return (ResponseEntity<LiveGame>) ResponseEntity.notFound();
//        }
//        return ResponseEntity.ok(game);
//    }
}
