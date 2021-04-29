package no.ntnu.sjakkskjerm.message;

import no.ntnu.sjakkskjerm.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessage() {
        return messageRepository.findAll();
    }

    public void sendMessage(MessageRequest message, Tournament tournament) {
        Message messageEntity = new Message();
        messageEntity.setTournament(tournament);
        messageEntity.setDate(LocalDate.now());
        messageEntity.setMessage(message.getMessage());
        messageEntity.setImportance(message.getImportance());
        messageRepository.save(messageEntity);
    }

    public List<Message> getMessageTournament(Long tournamentId) {
       return messageRepository.findAll()
               .stream()
               .filter(c -> tournamentId.equals(c.getTournament().getId()))
               .collect(Collectors.toList());
    }
}
