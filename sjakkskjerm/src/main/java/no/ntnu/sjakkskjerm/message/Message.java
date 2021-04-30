package no.ntnu.sjakkskjerm.message;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Message {

    @Id
    @SequenceGenerator(name = "melding_sequence", sequenceName = "melding_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "melding_sequence")
    private Long messageId;

    private Long tournamentId;
    private LocalDate date;
    private String importance;
    private String message;

    public Message() {
    }

    public Message(Long tournamentId, LocalDate date, String importance, String message) {
        this.tournamentId = tournamentId;
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

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
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
                ", tournamentId=" + tournamentId +
                ", date=" + date +
                ", importance='" + importance + '\'' +
                ", Message='" + message + '\'' +
                '}';
    }
}
