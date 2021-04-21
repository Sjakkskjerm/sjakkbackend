package no.ntnu.sjakkskjerm.livegame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.sjakkskjerm.livegame.pgn.PGN;
import no.ntnu.sjakkskjerm.tournament.Tournament;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Represents a live game being played on digital chessboards. Digital chessboards
 * and accompanying software can produce a {@link PGN} (Portable Game Notation)
 * representation of the state on the board. {@link LiveGame} will not hold
 * any information present in the PGN.
 */
@Entity
@Table
public class LiveGame {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournament_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Tournament tournament;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "liveGame")
    private PGN pgn;

    public LiveGame() {
    }

    public LiveGame(String id, Tournament tournament, PGN pgn) {
        this.id = id;
        this.tournament = tournament;
        this.pgn = pgn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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
        return id.equals(game.id) && tournament.equals(game.tournament) && pgn.equals(game.pgn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tournament, pgn);
    }

    @Override
    public String toString() {
        return "LiveGame{" +
                "id=" + id +
                '}';
    }
}
