package edu.icet.crm.service;

import edu.icet.crm.dto.ApiResponse;
import edu.icet.crm.dto.Email;
import org.springframework.beans.factory.annotation.Value;
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

    public ResponseEntity<ApiResponse> sendingEmail(Email email) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(email.getRecipient());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getMessage());

            emailSender.send(mailMessage);

            // Return success response
            return ResponseEntity.ok(new ApiResponse("success", "Email sent successfully"));

        } catch (Exception ex) {
            // Return error response
            return ResponseEntity.status(500).body(new ApiResponse("error", "Failed to send email. Error: " + ex.getMessage()));
        }
    }
}