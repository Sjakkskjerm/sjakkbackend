package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.livegame.LiveGame;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name="tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfRounds;
    private int gamesPerRound;
    private String tournamentOrganizer;
    private String tournamentName;
    private Long owner;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tournament")
    private List<LiveGame> games;

    public Tournament() { }

    public Tournament(Long id, LocalDate startDate, LocalDate endDate, int numberOfRounds, int gamesPerRound, String tournamentOrganizer, String tournamentName, Long owner, List<LiveGame> games) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfRounds = numberOfRounds;
        this.gamesPerRound = gamesPerRound;
        this.tournamentOrganizer = tournamentOrganizer;
        this.tournamentName = tournamentName;
        this.owner = owner;
        this.games = games;
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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public List<LiveGame> getGames() {
        return games;
    }

    public void setGames(List<LiveGame> games) {
        this.games = games;
    }

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
                '}';
    }
}