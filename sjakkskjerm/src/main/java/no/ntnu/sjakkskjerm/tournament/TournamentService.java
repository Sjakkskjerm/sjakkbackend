package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.livegame.LiveGame;
import no.ntnu.sjakkskjerm.livegame.LiveGameRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final LiveGameRepository liveGameRepository;

    public TournamentService(TournamentRepository tournamentRepository, LiveGameRepository liveGameRepository) {
        this.tournamentRepository = tournamentRepository;
        this.liveGameRepository = liveGameRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournament(Long id) {
        return tournamentRepository.getOne(id);
    }

    public void addTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public String addGameToTournament(Long tournamentId, String gameId) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        Optional<LiveGame> liveGameOptional = liveGameRepository.findById(tournamentId.toString()+gameId);
        if (!tournamentOptional.isPresent() || liveGameOptional.isPresent()) {
            return null;
        }
        Tournament tournament = tournamentOptional.get();
        LiveGame liveGame = new LiveGame();
        liveGame.setId(tournament.getId() + gameId);
        liveGame.setTournament(tournament);
        List<LiveGame> games = tournament.getGames();
        games.add(liveGame);
        tournament.setGames(games);
        tournamentRepository.save(tournament);
        return liveGame.getId();
    }
}
