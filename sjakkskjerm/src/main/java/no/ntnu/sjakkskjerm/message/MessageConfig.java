package no.ntnu.sjakkskjerm.message;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class MessageConfig {

    @Bean
    CommandLineRunner commandLineRunner(MessageRepository repository) {
        return args -> {
            Message mtest = new Message(
                   1,
                    LocalDate.of(2000, JANUARY,5),
                   "Viktig",
                   "Hei"
            );
            Message mtest2 = new Message(
                    1,
                    LocalDate.of(2001, JANUARY,5),
                    "Viktig",
                    "HeiHei"
            );
            Message mtest3 = new Message(
                    1,
                    LocalDate.of(2002, JANUARY,5),
                    "Viktig",
                    "HeiHeiHeiHei"
            );

            repository.saveAll(
                    List.of(mtest)
            );
        };
    }
}
