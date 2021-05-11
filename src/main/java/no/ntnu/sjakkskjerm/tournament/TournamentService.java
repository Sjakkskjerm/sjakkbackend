package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.auth.models.User;
import no.ntnu.sjakkskjerm.auth.repositories.UserRepository;
import no.ntnu.sjakkskjerm.livegame.LiveGame;
import no.ntnu.sjakkskjerm.livegame.LiveGameRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TournamentService {

    private final UserRepository userRepository;
    private final TournamentRepository tournamentRepository;
    private final LiveGameRepository liveGameRepository;

    public TournamentService(UserRepository userRepository, TournamentRepository tournamentRepository, LiveGameRepository liveGameRepository) {
        this.userRepository = userRepository;
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

    public Tournament addTournament(Tournament tournament, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            tournament.setOwner(userOptional.get());
            tournamentRepository.save(tournament);
            return tournament;
        }
        return null;
    }

    public void deleteTournament(Long id) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);
        tournamentOptional.ifPresent(tournamentRepository::delete);
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

    private String validGameId(String gameId) {
        System.out.println(gameId);
        if (gameId.length() > 1) {
            return  gameId;
        }
        return "0"+gameId;
    }

    public List<Tournament> getTournamentsById(Long ownerId) {
        return tournamentRepository.findAll()
                .stream()
                .filter(tournament -> tournament.getOwner().getUserId().equals(ownerId))
                .collect(Collectors.toList());
    }
}
