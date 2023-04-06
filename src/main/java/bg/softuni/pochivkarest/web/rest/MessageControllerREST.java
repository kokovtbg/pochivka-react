package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.MessageDTO;
import bg.softuni.pochivkarest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class MessageControllerREST {
    private final MessageService messageService;

    @Autowired
    public MessageControllerREST(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send-message")
    public MessageDTO sendMessage(@RequestBody MessageDTO messageDTO) {
        return messageService.sendMessage(messageDTO);
    }

    @GetMapping("/messages-input-rest/{username}")
    public List<MessageDTO> getAllInputMessages(@PathVariable String username) {
        return messageService.getAllReceivedMessages(username);
    }

    @GetMapping("/message-read-rest/{id}")
    public MessageDTO getMessage(@PathVariable long id) {
        return messageService.getMessageById(id);
    }
}
