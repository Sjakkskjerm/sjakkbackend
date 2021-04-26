package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.auth.models.Role;
import no.ntnu.sjakkskjerm.auth.models.RoleEnum;
import no.ntnu.sjakkskjerm.auth.repositories.RoleRepository;
import no.ntnu.sjakkskjerm.livegame.LiveGame;
import no.ntnu.sjakkskjerm.livegame.LiveGameService;
import no.ntnu.sjakkskjerm.livegame.pgn.PGN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TournamentConfig {

    @Bean
    CommandLineRunner addTournamentsToDatabase(TournamentRepository repository) {
        return args -> {

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

            LiveGame gameOneTournamentOne = new LiveGame();
            LiveGame gameTwoTournamentOne = new LiveGame();
            LiveGame gameThreeTournamentOne = new LiveGame();
            LiveGame gameFourTournamentTwo = new LiveGame();
            LiveGame gameFiveTournamentTwo = new LiveGame();
            LiveGame gameSixTournamentTwo = new LiveGame();
            LiveGame gameSevenTournamentTwo = new LiveGame();
            LiveGame gameEightTournamentTwo = new LiveGame();
            LiveGame gameNineTournamentTwo = new LiveGame();

            gameOneTournamentOne.setId("101");
            gameTwoTournamentOne.setId("102");
            gameThreeTournamentOne.setId("103");
            gameFourTournamentTwo.setId("201");
            gameFiveTournamentTwo.setId("202");
            gameSixTournamentTwo.setId("203");
            gameSevenTournamentTwo.setId("204");
            gameEightTournamentTwo.setId("205");
            gameNineTournamentTwo.setId("206");

            gameOneTournamentOne.setPgn(pgnOne);
            gameTwoTournamentOne.setPgn(pgnTwo);
            gameThreeTournamentOne.setPgn(pgnThree);
            gameFourTournamentTwo.setPgn(pgnFour);
            gameFiveTournamentTwo.setPgn(pgnFive);
            gameSixTournamentTwo.setPgn(pgnSix);
            gameSevenTournamentTwo.setPgn(pgnSeven);
            gameEightTournamentTwo.setPgn(pgnEight);
            gameNineTournamentTwo.setPgn(pgnNine);

            pgnOne.setLiveGame(gameOneTournamentOne);
            pgnTwo.setLiveGame(gameTwoTournamentOne);
            pgnThree.setLiveGame(gameThreeTournamentOne);
            pgnFour.setLiveGame(gameFourTournamentTwo);
            pgnFive.setLiveGame(gameFiveTournamentTwo);
            pgnSix.setLiveGame(gameSixTournamentTwo);
            pgnSeven.setLiveGame(gameSevenTournamentTwo);
            pgnEight.setLiveGame(gameEightTournamentTwo);
            pgnNine.setLiveGame(gameNineTournamentTwo);

            Tournament tournamentOne = new Tournament();
            tournamentOne.setStartDate(LocalDate.of(2021, APRIL, 5));
            tournamentOne.setEndDate(LocalDate.of(2021, APRIL, 20));
            tournamentOne.setTournamentOrganizer("Ola Normann");
            tournamentOne.setTournamentName("The Easter Chess Championship 2021");
            tournamentOne.setGames(List.of(gameOneTournamentOne, gameTwoTournamentOne, gameThreeTournamentOne));
            gameOneTournamentOne.setTournament(tournamentOne);
            gameTwoTournamentOne.setTournament(tournamentOne);
            gameThreeTournamentOne.setTournament(tournamentOne);

            Tournament tournamentTwo = new Tournament();
            tournamentTwo.setStartDate(LocalDate.of(2021, JUNE, 5));
            tournamentTwo.setEndDate(LocalDate.of(2021, JUNE, 15));
            tournamentTwo.setTournamentOrganizer("Per Atle Steinar");
            tournamentTwo.setTournamentName("Per Atle Steinars Toten Turnering");
            tournamentTwo.setGames(List.of(gameFourTournamentTwo, gameFiveTournamentTwo, gameSixTournamentTwo, gameSevenTournamentTwo, gameEightTournamentTwo, gameNineTournamentTwo));
            gameFourTournamentTwo.setTournament(tournamentTwo);
            gameFiveTournamentTwo.setTournament(tournamentTwo);
            gameSixTournamentTwo.setTournament(tournamentTwo);
            gameSevenTournamentTwo.setTournament(tournamentTwo);
            gameEightTournamentTwo.setTournament(tournamentTwo);
            gameNineTournamentTwo.setTournament(tournamentTwo);

            Tournament tournamentThree = new Tournament();
            tournamentThree.setStartDate(LocalDate.of(2021, DECEMBER, 25));
            tournamentThree.setEndDate(LocalDate.of(2022, JANUARY, 5));
            tournamentThree.setTournamentOrganizer("Julenissen");
            tournamentThree.setTournamentName("New Year 2021  North Pole Chess Open");

            repository.saveAll(
                    List.of(tournamentOne, tournamentTwo, tournamentThree)
            );
        };
    }

    @Bean
    CommandLineRunner addGameToTournament(TournamentRepository repository, TournamentService service) {
        return args -> {
            Tournament tournament = repository.getOne(3L);
            service.addGameToTournament(tournament.getId(), "01");
        };
    }

    @Bean
    CommandLineRunner addRoles(RoleRepository repository) {
        return args -> {
          repository.save(new Role(RoleEnum.ROLE_USER));
          repository.save(new Role(RoleEnum.ROLE_ORGANIZER));
          repository.save(new Role(RoleEnum.ROLE_ADMIN));
        };
    }

    @Bean
    CommandLineRunner addPGNToGame(LiveGameService service) {
        return args -> {
            ArrayList<String> pgnStepOne = new ArrayList<>(List.of(
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
                    "1.e4"
            ));
            ArrayList<String> pgnStepTwo = new ArrayList<>(List.of(
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
                    "1.e4 e5"
            ));
            ArrayList<String> pgnStepThree = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3"
            ));
            ArrayList<String> pgnStepFour = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6"
            ));
            ArrayList<String> pgnStepFive = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4"
            ));
            ArrayList<String> pgnStepSix = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5"
            ));
            ArrayList<String> pgnStepSeven = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4"
            ));
            ArrayList<String> pgnStepEight = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4"
            ));
            ArrayList<String> pgnStepNine = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3"
            ));
            ArrayList<String> pgnStepTen = new ArrayList<>(List.of(
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
                    "1.e4 e5 2.Nf3 Nc6 3.Bc4 Bc5 4.b4 Bxb4 5.c3 Ba5"));
            ArrayList<ArrayList<String>> pgnSteps = new ArrayList<ArrayList<String>>(List.of(
                    pgnStepOne,
                    pgnStepTwo,
                    pgnStepThree,
                    pgnStepFour,
                    pgnStepFive,
                    pgnStepSix,
                    pgnStepSeven,
                    pgnStepEight,
                    pgnStepNine,
                    pgnStepTen
            ));
            long timeBetweenSteps = 2000L;
            long nextStepTime = System.currentTimeMillis() + timeBetweenSteps;
            long maxRunTime = System.currentTimeMillis() + 1000000000L; //1800000 milliseconds = 30 minutes
            boolean finished = false;
            int step = 0;
            int maxSteps = pgnSteps.size() - 1;

            while (!finished) {
                if (nextStepTime < System.currentTimeMillis()) {
                    service.updateGame("301", pgnSteps.get(step));
                    nextStepTime+= timeBetweenSteps;
                    step++;
                }
                if (step == maxSteps) {
                    step = 0;
                }
//                if (System.currentTimeMillis() >= maxRunTime) {
//                    finished = true;
//                }
            }
        };
    }
}
