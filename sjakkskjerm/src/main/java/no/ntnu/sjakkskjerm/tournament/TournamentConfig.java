package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.message.Message;
import no.ntnu.sjakkskjerm.message.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.JANUARY;

@Configuration
public class TournamentConfig {

    @Bean
    CommandLineRunner commandLineRunner2(TournamentRepository repository) {
        return args -> {
            Tournament testTournament = new Tournament(
                   1L,
                    LocalDate.of(2021, APRIL, 10),
                    LocalDate.of(2021, APRIL, 20),
                    5,
                    4,
                    "Ola Normann"
            );


            repository.saveAll(
                    List.of(testTournament)
            );
        };
    }
}
