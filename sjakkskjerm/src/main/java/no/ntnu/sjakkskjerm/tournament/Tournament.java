package no.ntnu.sjakkskjerm.tournament;

import javax.persistence.*;
import java.time.LocalDate;

/*
 * An entity class for tournaments
 */
@Entity
@Table
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")
    private Long id;                     // Unique ID for each tournament

    private LocalDate startDate;         // The start date of the tournament
    private LocalDate endDate;           // The end date of the tournament
    private int numberOfRounds;          // The number of rounds that will be played in the tournament
    private int gamesPerRound;           // The number of games per round that will be played in the tournament
    private String tournamentOrganizer;  // The person or club that arranges/organizes the tournament
    private String tournamentName;       // The name of the tournament
    private Long owner;                  // The ID of a user in the system that is an Owner

    public Tournament() { }

    public Tournament(Long id, LocalDate startDate, LocalDate endDate, int numberOfRounds, int gamesPerRound,
                       String tournamentOrganizer, String tournamentName) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfRounds = numberOfRounds;
        this.gamesPerRound = gamesPerRound;
        this.tournamentOrganizer = tournamentOrganizer;
        this.tournamentName = tournamentName;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getNumberOfRounds() { return numberOfRounds; }

    public int getGamesPerRound() {
        return gamesPerRound;
    }

    public String getTournamentOrganizer() {
        return tournamentOrganizer;
    }

    public String getTournamentName() { return tournamentName; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void setGamesPerRound(int gamesPerRound) {
        this.gamesPerRound = gamesPerRound;
    }

    public void setTournamentOrganizer(String tournamentOrganizer) {
        this.tournamentOrganizer = tournamentOrganizer;
    }

    public void setTournamentName(String tournamentName) { this.tournamentName = tournamentName; }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfRounds=" + numberOfRounds +
                ", gamesPerRound=" + gamesPerRound +
                ", tournamentOrganizer='" + tournamentOrganizer + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", owner=" + owner +
                '}';
    }
}