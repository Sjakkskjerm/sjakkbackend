package no.ntnu.sjakkskjerm.livegame;

import no.ntnu.sjakkskjerm.livegame.pgn.PGN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Transactional
public class LiveGameConfig {

    @Bean
    CommandLineRunner addTestLiveGames(LiveGameRepository liveGameRepository) {
        return  args -> {


            ArrayList<String> pgnExampleOne = new ArrayList<>(List.of(
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
                    "23.Bd7+ Kf8 24.Bxe7# 1-0"
            ));

            ArrayList<String> pgnExampleTwo = new ArrayList<>(List.of(
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

            ArrayList<String> pgnExampleThree = new ArrayList<>(List.of(
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

            ArrayList<String> pgnExampleFour = new ArrayList<>(List.of(
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

            PGN pgnOne = new PGN();
            PGN pgnTwo = new PGN();
            PGN pgnThree = new PGN();
            PGN pgnFour = new PGN();
            PGN pgnFive = new PGN();
            PGN pgnSix = new PGN();
            PGN pgnSeven = new PGN();
            PGN pgnEight = new PGN();
            PGN pgnNine = new PGN();

            pgnOne.setLines(pgnExampleOne);
            pgnTwo.setLines(pgnExampleTwo);
            pgnThree.setLines(pgnExampleThree);
            pgnFour.setLines(pgnExampleFour);
            pgnFive.setLines(pgnExampleOne);
            pgnSix.setLines(pgnExampleTwo);
            pgnSeven.setLines(pgnExampleThree);
            pgnEight.setLines(pgnExampleFour);
            pgnNine.setLines(pgnExampleOne);

            LiveGame gameOneTournamentOne = new LiveGame(1L,1L,pgnOne);
            LiveGame gameTwoTournamentOne = new LiveGame(2L,1L,pgnTwo);
            LiveGame gameThreeTournamentOne = new LiveGame(3L,1L,pgnThree);

            LiveGame gameFourTournamentTwo = new LiveGame(4L,2L,pgnFour);
            LiveGame gameFiveTournamentTwo = new LiveGame(5L, 2L, pgnFive);
            LiveGame gameSixTournamentTwo = new LiveGame(6L, 2L, pgnSix);
            LiveGame gameSevenTournamentTwo = new LiveGame(7L, 2L, pgnSeven);
            LiveGame gameEightTournamentTwo = new LiveGame(8L, 2L, pgnEight);
            LiveGame gameNineTournamentTwo = new LiveGame(9L, 2L, pgnNine);


            pgnOne.setLiveGame(gameOneTournamentOne);
            pgnTwo.setLiveGame(gameTwoTournamentOne);
            pgnThree.setLiveGame(gameThreeTournamentOne);
            pgnFour.setLiveGame(gameFourTournamentTwo);
            pgnFive.setLiveGame(gameFiveTournamentTwo);
            pgnSix.setLiveGame(gameSixTournamentTwo);
            pgnSeven.setLiveGame(gameSevenTournamentTwo);
            pgnEight.setLiveGame(gameEightTournamentTwo);
            pgnNine.setLiveGame(gameNineTournamentTwo);

            liveGameRepository.saveAll(List.of(gameOneTournamentOne, gameTwoTournamentOne, gameThreeTournamentOne, gameFourTournamentTwo, gameFiveTournamentTwo, gameSixTournamentTwo, gameSevenTournamentTwo,gameEightTournamentTwo ,gameNineTournamentTwo));
        };
    }
}
