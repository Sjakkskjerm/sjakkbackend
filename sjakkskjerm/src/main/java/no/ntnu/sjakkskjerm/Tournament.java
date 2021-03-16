package no.ntnu.sjakkskjerm;


import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

// En entitetsklasse for turneringer
@Entity
public class Tournament {
    @Id
    private Long id;                     //Unik ID for hver enkel turnering
    private String startDate;           //Startdato for turnering
    private String endDate;             //Sluttdato for turnering
    private int numberOfRounds;         //Antall runder som skal spilles i turneringen
    private int gamesPerRound;           //Antall kamper per runde som skal spilles i turneringen
    private String tournamentOrganizer;  //Personen eller klubben som står for arrangering av turneringen

    public Tournament() { }

    public Tournament(Long id, String startDate, String endDate, int numberOfRounds, int gamesPerRound,
                       String tournamentOrganizer) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfRounds = numberOfRounds;
        this.gamesPerRound = gamesPerRound;
        this.tournamentOrganizer = tournamentOrganizer;
    }

    @javax.persistence.Id
    public Long getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getNumberOfRounds() { return numberOfRounds; }

    public int getGamesPerRound() {
        return gamesPerRound;
    }

    public String getTournamentOrganizer() {
        return tournamentOrganizer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
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

}