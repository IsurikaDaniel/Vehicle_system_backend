package edu.icet.crm.controller;

import edu.icet.crm.dto.Email;
import edu.icet.crm.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService service;

    public EmailController(EmailService service){
        this.service = service;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email email){
        return service.sendingEmail(email);
    }
}
