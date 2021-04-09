package no.ntnu.sjakkskjerm.tournament;


import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import java.time.LocalDate;

/*
 * An entity class for tournaments
 */
@Entity
public class Tournament {
    @Id
    private Long id;                     //Unique ID for each tournament
    private LocalDate startDate;         //The start date of the tournament
    private LocalDate endDate;           //The end date of the tournament
    private int numberOfRounds;          //The number of rounds that will be played in the tournament
    private int gamesPerRound;           //The number of games per round that will be played in the tournament
    private String tournamentOrganizer;  //The person or club that arranges/organizes the tournament
    private String tournamentName;       //The name of the tournament

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

    @javax.persistence.Id
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

}