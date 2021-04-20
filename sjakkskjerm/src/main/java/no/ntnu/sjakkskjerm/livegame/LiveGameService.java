package no.ntnu.sjakkskjerm.livegame;

import no.ntnu.sjakkskjerm.livegame.pgn.PGN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LiveGameService {

    private final LiveGameRepository liveGameRepository;

    @Autowired
    public LiveGameService(LiveGameRepository liveGameRepository) {
        this.liveGameRepository = liveGameRepository;
    }

    public List<LiveGame> getGames() {
        return liveGameRepository.findAll();
    }

    public LiveGame getGame(String liveGameId) {
        if (liveGameId == null) {
            return null;
        }
        Optional<LiveGame> games= liveGameRepository.findById(liveGameId);
        return games.orElse(null);
    }

    public List<LiveGame> getGamesByTournamentId(Long tournamentId) {
        return liveGameRepository.findByTournamentIdOrderByTournamentIdAsc(tournamentId);
    }

    public LiveGame updateGame(String liveGameId, List<String> pgn) {
        Optional<LiveGame> liveGame = liveGameRepository.findById(liveGameId);
        if (!liveGame.isPresent() || pgn.isEmpty()) {
            return null;
        }
        LiveGame gameToUpdate = liveGame.get();
        liveGameRepository.delete(gameToUpdate);
        List<String> trimmedPGN = trimPGN(pgn);
        PGN newPGn = new PGN();
        newPGn.setLines(trimmedPGN);
        newPGn.setLiveGame(gameToUpdate);
        gameToUpdate.setPgn(newPGn);
        liveGameRepository.save(gameToUpdate);
        return gameToUpdate;
    }

    private List<String> trimPGN(List<String> pgn) {
        ArrayList<String> trimmedList = new ArrayList<>();
        for (String line : pgn) {
            trimmedList.add(line.replace("\"", ""));
        }
        return trimmedList;
    }
}
