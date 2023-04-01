package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.MessageDTO;
import bg.softuni.pochivkarest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
