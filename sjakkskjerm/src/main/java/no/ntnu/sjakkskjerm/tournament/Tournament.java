package no.ntnu.sjakkskjerm.tournament;

import no.ntnu.sjakkskjerm.auth.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.sjakkskjerm.livegame.LiveGame;
import no.ntnu.sjakkskjerm.message.Message;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tournament")
    @JsonIgnore
    private List<LiveGame> games;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tournament")
    @JsonIgnore
    private Set<Message> messages;

    public Tournament() { }

    public Tournament(Long id, LocalDate startDate, LocalDate endDate, int numberOfRounds, int gamesPerRound, String tournamentOrganizer, String tournamentName, Long owner, List<LiveGame> games) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfRounds = numberOfRounds;
        this.gamesPerRound = gamesPerRound;
        this.tournamentOrganizer = tournamentOrganizer;
        this.tournamentName = tournamentName;
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

    public List<LiveGame> getGames() {
        return games;
    }

    public void setGames(List<LiveGame> games) {
        this.games = games;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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