package no.ntnu.sjakkskjerm.livegame;

import no.ntnu.sjakkskjerm.livegame.pgn.PGN;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Represents a live game being played on digital chessboards. Digital chessboards
 * and accompanying software can produce a PGN (Portable Game Notation)
 * representation of the state on the board. {@code LiveGame} will not hold
 * any information present in the PGN.
 */
@Entity
@Table
public class LiveGame {

    @Id
//    @SequenceGenerator(name="livegame_sequence", sequenceName = "melding_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livegame_sequence")
    private Long id;
    @NotNull
    private Long tournamentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "liveGame")
    private PGN pgn;

    public LiveGame() {
    }

    public LiveGame(Long id, Long tournamentId, PGN pgn) {
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

    public PGN getPgn() {
        return pgn;
    }

    public void setPgn(PGN pgn) {
        this.pgn = pgn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LiveGame game = (LiveGame) o;
        return id.equals(game.id) && tournamentId.equals(game.tournamentId) && pgn.equals(game.pgn);
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
                ", pgn=" + pgn +
                '}';
    }
}
