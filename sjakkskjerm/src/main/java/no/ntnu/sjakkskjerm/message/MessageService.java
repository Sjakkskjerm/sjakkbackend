package no.ntnu.sjakkskjerm.message;

import no.ntnu.sjakkskjerm.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

    @Transactional
    public void deleteMessage(Long messageId) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if (messageOptional.isPresent()) {
            var message = messageOptional.get();
            var tournament = message.getTournament();
            tournament.removeMessage(message);
        }
        messageRepository.deleteById(messageId);
    }

    public List<Message> getMessageTournament(Long tournamentId) {
       return messageRepository.findAll()
               .stream()
               .filter(c -> tournamentId.equals(c.getTournament().getId()))
               .collect(Collectors.toList());
    }
}
