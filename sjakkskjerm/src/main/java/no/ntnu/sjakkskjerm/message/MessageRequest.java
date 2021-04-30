package no.ntnu.sjakkskjerm.message;

import javax.validation.constraints.NotBlank;

public class MessageRequest {

    @NotBlank
    private Long tournamentId;

    @NotBlank
    private String message;

    @NotBlank
    private String importance;

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }
}
