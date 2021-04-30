package no.ntnu.sjakkskjerm.message;


import no.ntnu.sjakkskjerm.auth.exceptions.NotAuthorizedException;
import no.ntnu.sjakkskjerm.auth.security.services.UserDetailsImpl;
import no.ntnu.sjakkskjerm.tournament.Tournament;
import no.ntnu.sjakkskjerm.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/message")
@CrossOrigin(origins="*", maxAge = 3600, allowedHeaders = "*")
public class MessageController {

    private final MessageService messageService;
    private final TournamentService tournamentService;

    @Autowired
    public MessageController(MessageService messageService, TournamentService tournamentService) {
        this.messageService = messageService;
        this.tournamentService = tournamentService;
    }

    @GetMapping
    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    public List<Message> getMessages() {
        return messageService.getMessage();
    }

    @PostMapping
    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PreAuthorize("hasAuthority('ROLE_ORGANIZER')")
    public void sendMessage(@RequestBody MessageRequest message) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Long userId = userDetails.getUserId();
        Tournament tournament = tournamentService.getTournament(message.getTournamentId());
        if (!tournament.getOwner().getUserId().equals(userId)) {
            throw new NotAuthorizedException();
        }
        messageService.sendMessage(message, tournament);
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path = "/specific")
    public List<Message> getMessageTournament(@RequestParam Long tournamentId) {
        return messageService.getMessageTournament(tournamentId);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ORGANIZER')")
    public void deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
        System.out.println(messageId);
    }

}
