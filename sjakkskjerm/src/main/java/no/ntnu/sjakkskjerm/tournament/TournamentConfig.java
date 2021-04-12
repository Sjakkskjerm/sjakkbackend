package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.message.Message;
import no.ntnu.sjakkskjerm.message.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TournamentConfig {

    @Bean
    CommandLineRunner commandLineRunner2(TournamentRepository repository) {
        return args -> {
            Tournament testTournament = new Tournament(
                   123L,
                    LocalDate.of(2021, APRIL, 5),
                    LocalDate.of(2021, APRIL, 20),
                    5,
                    4,
                    "Ola Normann",
                    "The Easter Chess Championship 2021"
            );
            Tournament testTournament2 = new Tournament(
                    124L,
                    LocalDate.of(2021, JUNE, 5),
                    LocalDate.of(2021, JUNE, 15),
                    6,
                    3,
                    "Per Atle Steinar",
                    "Per Atle Steinars Toten Turnering"
            );
            Tournament testTournament3 = new Tournament(
                    125L,
                    LocalDate.of(2021, DECEMBER, 25),
                    LocalDate.of(2022, JANUARY, 5),
                    9,
                    2,
                    "Julenissen",
                    "New Year 2021  North Pole Chess Open"
            );

            repository.saveAll(
                    List.of(testTournament, testTournament2, testTournament3)
            );
        };
    }
}
