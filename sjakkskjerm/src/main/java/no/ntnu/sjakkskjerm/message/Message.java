package no.ntnu.sjakkskjerm.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.ntnu.sjakkskjerm.tournament.Tournament;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Message {

    @Id
    @SequenceGenerator(name = "melding_sequence", sequenceName = "melding_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "melding_sequence")
    private Long messageId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tournament_id", nullable = false)
    @JsonIgnore
    private Tournament tournament;
    private LocalDate date;
    private String importance;
    private String message;

    public Message() {
    }

    public Message(Tournament tournament, LocalDate date, String importance, String message) {
        this.tournament = tournament;
        this.date = date;
        this.importance = importance;
        this.message = message;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Tournament getTournament() {
        return this.tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", date=" + date +
                ", importance='" + importance + '\'' +
                ", Message='" + message + '\'' +
                '}';
    }
}
