package no.ntnu.sjakkskjerm.livegame.pgn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.sjakkskjerm.livegame.LiveGame;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Portable Game Notation (PGN). The value of a PGN contains
 * event information and move text.
 * See <a href="https://en.wikipedia.org/wiki/Portable_Game_Notation">Portable Game Notation</a>.
 */
@Entity
@Table(name = "pgns")
public class PGN {

    @Id
    @SequenceGenerator(name="pgn_sequence", sequenceName = "pgn_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pgn_sequence")
    private Long id;

    @ElementCollection
    private List<String> lines;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "livegame_id", nullable = false)
    private LiveGame liveGame;

    public PGN() {
    }

    public PGN(Long id, List<String> lines, LiveGame liveGame) {
        this.id = id;
        this.lines = lines;
        this.liveGame = liveGame;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public LiveGame getLiveGame() {
        return liveGame;
    }

    public void setLiveGame(LiveGame liveGame) {
        this.liveGame = liveGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PGN pgn = (PGN) o;
        return id.equals(pgn.id) && lines.equals(pgn.lines) && liveGame.equals(pgn.liveGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lines, liveGame);
    }

    @Override
    public String toString() {
        return "PGN{" +
                "id=" + id +
                ", lines=" + lines +
                ", liveGame=" + liveGame +
                '}';
    }
}
