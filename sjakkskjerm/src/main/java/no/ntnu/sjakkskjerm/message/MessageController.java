package no.ntnu.sjakkskjerm.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    public List<Message> getMessages() {
        return messageService.getMessage();
    }

    @PostMapping
    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PreAuthorize("hasAuthority('ROLE_ORGANIZER')")
    public void sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(path = "/specific")
    public List<Message> getMessageTournament(@RequestParam Long tournamentId) {
        System.out.println(tournamentId);
        return messageService.getMessageTournament(tournamentId);
    }

}
