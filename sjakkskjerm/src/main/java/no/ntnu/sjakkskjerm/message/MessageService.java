package no.ntnu.sjakkskjerm.message;

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

    public void sendMessage(Message message) {
        message.setDate(LocalDate.now());
        messageRepository.save(message);
    }

    public List<Message> getMessageTournament(Long tournamentId) {

        List<Message> originalList = messageRepository.findAll();

       List<Message> filteredList =
                originalList
                    .stream()
                    .filter(c -> tournamentId.equals(c.getTournamentId()))
                    .collect(Collectors.toList());

        filteredList.forEach(System.out::println);

       return filteredList;
    }
}
