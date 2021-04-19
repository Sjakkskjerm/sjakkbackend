package no.ntnu.sjakkskjerm.livegame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
