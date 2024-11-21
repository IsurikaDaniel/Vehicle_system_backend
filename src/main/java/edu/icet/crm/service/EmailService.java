package edu.icet.crm.service;

import edu.icet.crm.dto.ApiResponse;
import edu.icet.crm.dto.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public ResponseEntity<ApiResponse> sendEmail(Email email) {
        try {
            // Create and configure the email message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(email.getRecipient());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getMessage());

            emailSender.send(mailMessage);

            return ResponseEntity.ok(new ApiResponse("200", "Email sent successfully.", true));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("500", "Failed to send email. Error: " + ex.getMessage(), false));
        }
    }
}
