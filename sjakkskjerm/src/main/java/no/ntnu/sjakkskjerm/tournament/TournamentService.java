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
        Optional<Tournament> tournament= tournamentRepository.findById(id);
        return tournament.orElse(null);
    }

    public void addTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public String addGameToTournament(Long tournamentId, String gameId) {
        String validatedGameId = validGameId(gameId);

        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        Optional<LiveGame> liveGameOptional = liveGameRepository.findById(tournamentId.toString()+validatedGameId);
        if (!tournamentOptional.isPresent() || liveGameOptional.isPresent()) {
            return null;
        }
        Tournament tournament = tournamentOptional.get();
        LiveGame liveGame = new LiveGame();
        liveGame.setId(tournament.getId() + validatedGameId);
        liveGame.setTournament(tournament);
        List<LiveGame> games = tournament.getGames();
        games.add(liveGame);
        tournament.setGames(games);
        tournamentRepository.save(tournament);
        return liveGame.getId();
    }

    private String validGameId(String gameId) {
        System.out.println(gameId);
        if (gameId.length() > 1) {
            return  gameId;
        }
        return "0"+gameId;
    }

    public Tournament setGamesPerRound(long tournamentId, int numberOfGames) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);
        if (!tournamentOptional.isPresent()) {
            return null;
        }
        Tournament tournament = tournamentOptional.get();
        tournament.setGamesPerRound(numberOfGames);
        tournamentRepository.save(tournament);
        return tournament;
    }

    public Tournament setNumberOfRounds(long tournamentid, int numberOfRounds) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentid);
        if (!tournamentOptional.isPresent()) {
            return null;
        }
        Tournament tournament = tournamentOptional.get();
        tournament.setNumberOfRounds(numberOfRounds);
        tournamentRepository.save(tournament);
        return tournament;
    }
}
