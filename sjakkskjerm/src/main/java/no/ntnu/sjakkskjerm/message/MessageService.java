package no.ntnu.sjakkskjerm.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public void sendMessage(Message message) {
        message.setDato(LocalDate.now());
        messageRepository.save(message);
    }

    public List<Message> getMessageTournament(Integer tournamentId) {

        List<Message> originalList = messageRepository.findAll();

       List<Message> originalList2 =
                originalList
                    .stream()
                    .filter(c -> tournamentId.equals(c.getTurneringsId()))
                    .collect(Collectors.toList());

       originalList2.forEach(System.out::println);

       return originalList2;
    }
}
