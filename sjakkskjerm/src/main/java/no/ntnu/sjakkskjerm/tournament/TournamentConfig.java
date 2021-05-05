package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.auth.models.Role;
import no.ntnu.sjakkskjerm.auth.models.RoleEnum;
import no.ntnu.sjakkskjerm.auth.models.User;
import no.ntnu.sjakkskjerm.auth.repositories.RoleRepository;
import no.ntnu.sjakkskjerm.auth.repositories.UserRepository;
import no.ntnu.sjakkskjerm.livegame.LiveGame;
import no.ntnu.sjakkskjerm.livegame.pgn.PGN;
import no.ntnu.sjakkskjerm.message.Message;
import no.ntnu.sjakkskjerm.message.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.*;

import static java.time.Month.*;

@Configuration
public class TournamentConfig {

    @Bean
    CommandLineRunner addRolesAndOrganizer(RoleRepository rolerepository,
                                           UserRepository userRepository,
                                           PasswordEncoder encoder) {
        return args -> {
            Role userRole = new Role(RoleEnum.ROLE_USER);
            Role organizerRole = new Role(RoleEnum.ROLE_ORGANIZER);
            Role adminRole = new Role(RoleEnum.ROLE_ADMIN);
            rolerepository.save(userRole);
            rolerepository.save(organizerRole);
            rolerepository.save(adminRole);

            User organizerUser = new User("organizer",
                    encoder.encode("organizer123"),
                    "organizer@organizer.com", "organizer");
            Set<Role> organizerRoles = new HashSet<>();
            organizerRoles.add(organizerRole);
            organizerUser.setRoleSet(organizerRoles);
            userRepository.save(organizerUser);

            User anotherOrganizer = new User("organizerTwo",
                    encoder.encode("organizerTwo"),
                    "organizerTwo@organizer.com",
                    "organizer");
            Set<Role> anotherOrganizerRoles = new HashSet<>();
            anotherOrganizerRoles.add(organizerRole);
            anotherOrganizer.setRoleSet(anotherOrganizerRoles);
            userRepository.save(anotherOrganizer);
        };
    }

    @Bean
    CommandLineRunner addAdmin(RoleRepository roleRepository,
                               UserRepository userRepository,
                               PasswordEncoder encoder) {
        return args -> {
          Optional<Role> adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN);
          if (adminRole.isPresent()) {
              User admin = new User("admin",
                      encoder.encode("admin123"),
                      "admin@admin.com",
                      "admin");
              Set<Role> adminRoles = new HashSet<>();
              adminRoles.add(adminRole.get());
              admin.setRoleSet(adminRoles);
              userRepository.save(admin);
          }
        };
    }

    @Bean
    CommandLineRunner addTournamentsToDatabase(TournamentRepository repository, UserRepository userRepository) {
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

            Tournament tournamentYouCanDelete = new Tournament();
            tournamentYouCanDelete.setStartDate(LocalDate.of(2021, DECEMBER, 25));
            tournamentYouCanDelete.setEndDate(LocalDate.of(2022, JANUARY, 5));
            tournamentYouCanDelete.setTournamentOrganizer("Martin");
            tournamentYouCanDelete.setTournamentName("Delete Me Tournament");

            Optional<User> possibleOwner = userRepository.findByUsername("organizer");
            if (possibleOwner.isPresent()) {
                User owner = possibleOwner.get();
                tournamentOne.setOwner(owner);
                tournamentTwo.setOwner(owner);
                tournamentThree.setOwner(owner);
                tournamentYouCanDelete.setOwner(owner);
                repository.saveAll(
                        List.of(tournamentOne, tournamentTwo, tournamentThree, tournamentYouCanDelete));
            }
        };
    }
    @Bean
    CommandLineRunner addMessagesToTournaments(MessageRepository repository, TournamentRepository tournamentRepository) {
        return args -> {
            Optional<Tournament> tournamentOneOptional = tournamentRepository.findById(1L);
            Optional<Tournament> tournamentTwoOptional = tournamentRepository.findById(2L);
            Optional<Tournament> tournamentThreeOptional = tournamentRepository.findById(3L);

            Message mtest = new Message();
            Message mtest2 = new Message();
            Message mtest3 = new Message();

            if(tournamentOneOptional.isPresent()) {
                mtest.setTournament(tournamentOneOptional.get());
                mtest.setDate(LocalDate.of(2000, JANUARY,5));
                mtest.setImportance("Viktig");
                mtest.setMessage("Hei");
                tournamentOneOptional.get().getMessages().add(mtest);
                repository.save(mtest);
            }
            if(tournamentTwoOptional.isPresent()) {
                mtest2.setTournament(tournamentTwoOptional.get());
                mtest2.setDate(LocalDate.of(2001, JANUARY,5));
                mtest2.setImportance("Viktig");
                mtest2.setMessage("Hei Hei");
                tournamentTwoOptional.get().getMessages().add(mtest2);
                repository.save(mtest2);
            }
            if(tournamentThreeOptional.isPresent()) {
                mtest3.setTournament(tournamentThreeOptional.get());
                mtest3.setDate(LocalDate.of(2002, JANUARY,5));
                mtest3.setImportance("Viktig");
                mtest3.setMessage("Hei Hei Hei");
                tournamentThreeOptional.get().getMessages().add(mtest3);
                repository.save(mtest3);
            }
        };
    }

    @Bean
    CommandLineRunner addGameToTournament(TournamentRepository repository, TournamentService service) {
        return args -> {
            Tournament tournament = repository.getOne(3L);
            service.addGameToTournament(tournament.getId(), "01");
        };
    }
}
