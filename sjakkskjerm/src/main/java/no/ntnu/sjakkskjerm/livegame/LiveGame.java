package no.ntnu.sjakkskjerm.livegame;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table
/**
 * Represents a live game being played on digital chessboards. Digital chessboards
 * and accompanying software can produce a PGN (Portable Game Notation)
 * representation of the state on the board. {@code LiveGame} will not hold
 * any information present in the PGN.
 */
public class LiveGame {

    @Id
//    @SequenceGenerator(name="livegame_sequence", sequenceName = "melding_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livegame_sequence")
    private Long id;
    @NotNull
    private Long tournamentId;

    @NotNull
    @ElementCollection
    private List<String> pgn;

    public LiveGame() {
    }

    public LiveGame(Long id, Long tournamentId, List<String> pgn) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.pgn = pgn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public List<String> getPgn() {
        return pgn;
    }

    public void setPgn(List<String> pgns) {
        this.pgn = pgns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LiveGame liveGame = (LiveGame) o;
        return id.equals(liveGame.id) && tournamentId.equals(liveGame.tournamentId) && pgn.equals(liveGame.pgn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tournamentId, pgn);
    }

    @Override
    public String toString() {
        return "LiveGame{" +
                "id=" + id +
                ", tournamentId=" + tournamentId +
                ", pgns=" + pgn +
                '}';
    }
}
