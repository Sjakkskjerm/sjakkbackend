package no.ntnu.sjakkskjerm.message;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Message {

    @Id
    @SequenceGenerator(name = "melding_sequence", sequenceName = "melding_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "melding_sequence")
    private Integer meldingId;

    private Integer turneringsId;
    private LocalDate dato;
    private String Viktighet;
    private String Melding;

    public Message() {
    }

    public Message(Integer turneringsId, LocalDate dato, String viktighet, String melding) {
        this.turneringsId = turneringsId;
        this.dato = dato;
        Viktighet = viktighet;
        Melding = melding;
    }

    public Integer getMeldingId() {
        return meldingId;
    }

    public void setMeldingId(Integer meldingId) {
        this.meldingId = meldingId;
    }

    public Integer getTurneringsId() {
        return turneringsId;
    }

    public void setTurneringsId(Integer turneringsId) {
        this.turneringsId = turneringsId;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getViktighet() {
        return Viktighet;
    }

    public void setViktighet(String viktighet) {
        Viktighet = viktighet;
    }

    public String getMelding() {
        return Melding;
    }

    public void setMelding(String melding) {
        Melding = melding;
    }

    @Override
    public String toString() {
        return "Message{" +
                "meldingId=" + meldingId +
                ", turneringsId=" + turneringsId +
                ", dato=" + dato +
                ", Viktighet='" + Viktighet + '\'' +
                ", Message='" + Melding + '\'' +
                '}';
    }
}
