package no.ntnu.sjakkskjerm.livegame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LiveGameConfig {

    @Bean
    CommandLineRunner addTestLiveGames(LiveGameRepository repository) {
        return  args -> {
            ArrayList<String> pgnGameOne = new ArrayList<>(List.of(
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
            ArrayList<String> pgnGameTwo = new ArrayList<>(List.of(
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
            ArrayList<String> pgnGameThree = new ArrayList<>(List.of(
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
            ArrayList<String> pgnGameFour = new ArrayList<>(List.of(
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
            LiveGame gameOne = new LiveGame(123L,123L,pgnGameOne);
            LiveGame gameTwo = new LiveGame(124L,123L,pgnGameTwo);
            LiveGame gameThree = new LiveGame(125L,123L,pgnGameThree);
            LiveGame gameFour = new LiveGame(126L,123L,pgnGameFour);
            repository.saveAll(List.of(gameOne, gameTwo, gameThree, gameFour));
        };
    }
}
