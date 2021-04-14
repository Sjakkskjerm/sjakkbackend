package no.ntnu.sjakkskjerm.livegame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LiveGameConfig {

    @Bean
    CommandLineRunner addTestLiveGames(LiveGameRepository repository) {
        return  args -> {
            ArrayList<String> pgnOne = new ArrayList<>(List.of(
                    "[Event 'Casual Game']",
                    "[Site 'Berlin GER']",
                    "[Date '1852.??.??']",
                    "[EventDate '?']",
                    "[Round '?']",
                    "[Result '1-0']",
                    "[White 'Adolf Anderssen']",
                    "[Black 'Jean Dufresne']",
                    "[ECO 'C52']",
                    "[WhiteElo '?']",
                    "[BlackElo '?']",
                    "[PlyCount '47']",
                    "",
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3 Ba5 6.d4 exd4 7.O-O",
                    "d3 8.Qb3 Qf6 9.e5 Qg6 10.Re1 Nge7 11.Ba3 b5 12.Qxb5 Rb8 13.Qa4",
                    "Bb6 14.Nbd2 Bb7 15.Ne4 Qf5 16.Bxd3 Qh5 17.Nf6+ gxf6 18.exf6,\n",
                    "Rg8 19.Rad1 Qxf3 20.Rxe7+ Nxe7 21.Qxd7+ Kxd7 22.Bf5+ Ke8,\n",
                    "23.Bd7+ Kf8 24.Bxe7# 1-0"));
            ArrayList<String> pgnTwo = new ArrayList<>(List.of(
                    "[Event 'Casual Game']",
                    "[Site 'Berlin GER']",
                    "[Date '1852.??.??']",
                    "[EventDate '?']",
                    "[Round '?']",
                    "[Result '1-0']",
                    "[White 'Adolf Anderssen']",
                    "[Black 'Jean Dufresne']",
                    "[ECO 'C52']",
                    "[WhiteElo '?']",
                    "[BlackElo '?']",
                    "[PlyCount '47']",
                    "",
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3 Ba5 6.d4 exd4 7.O-O",
                    "d3 8.Qb3 Qf6 9.e5 Qg6 10.Re1 Nge7 11.Ba3 b5 12.Qxb5 Rb8 13.Qa4"
            ));
            ArrayList<String> pgnThree = new ArrayList<>(List.of(
                    "[Event 'Casual Game']",
                    "[Site 'Berlin GER']",
                    "[Date '1852.??.??']",
                    "[EventDate '?']",
                    "[Round '?']",
                    "[Result '1-0']",
                    "[White 'Adolf Anderssen']",
                    "[Black 'Jean Dufresne']",
                    "[ECO 'C52']",
                    "[WhiteElo '?']",
                    "[BlackElo '?']",
                    "[PlyCount '47']",
                    "",
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3 Ba5 6.d4 exd4 7.O-O",
                    "d3 8.Qb3 Qf6 9.e5 Qg6 10.Re1 Nge7 11.Ba3 b5 12.Qxb5 Rb8 13.Qa4",
                    "Bb6 14.Nbd2 Bb7 15.Ne4 Qf5 16.Bxd3 Qh5 17.Nf6+ gxf6 18.exf6"));
            ArrayList<String> pgnFour = new ArrayList<>(List.of(
                    "[Event 'Casual Game']",
                    "[Site 'Berlin GER']",
                    "[Date '1852.??.??']",
                    "[EventDate '?']",
                    "[Round '?']",
                    "[Result '1-0']",
                    "[White 'Adolf Anderssen']",
                    "[Black 'Jean Dufresne']",
                    "[ECO 'C52']",
                    "[WhiteElo '?']",
                    "[BlackElo '?']",
                    "[PlyCount '47']",
                    "",
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3 Ba5"
            ));
            LiveGame gameOneTournamentOne = new LiveGame(1L,1L,pgnOne);
            LiveGame gameTwoTournamentOne = new LiveGame(2L,1L,pgnTwo);
            LiveGame gameThreeTournamentOne = new LiveGame(3L,1L,pgnThree);

            LiveGame gameFourTournamentTwo = new LiveGame(4L,2L,pgnFour);
            LiveGame gameFiveTournamentTwo = new LiveGame(5L, 2L, pgnOne);
            LiveGame gameSixTournamentTwo = new LiveGame(6L, 2L, pgnTwo);
            LiveGame gameSevenTournamentTwo = new LiveGame(7L, 2L, pgnThree);
            LiveGame gameEightTournamentTwo = new LiveGame(8L, 2L, pgnFour);
            LiveGame gameNineTournamentTwo = new LiveGame(9L, 2L, pgnOne);
            repository.saveAll(List.of(gameOneTournamentOne, gameTwoTournamentOne, gameThreeTournamentOne, gameFourTournamentTwo, gameFiveTournamentTwo, gameSixTournamentTwo, gameSevenTournamentTwo,gameEightTournamentTwo ,gameNineTournamentTwo));
        };
    }
}
