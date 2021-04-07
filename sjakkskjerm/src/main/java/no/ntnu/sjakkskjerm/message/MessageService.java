package no.ntnu.sjakkskjerm.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        messageRepository.save(message);
    }

}
