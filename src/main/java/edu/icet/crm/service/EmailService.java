package edu.icet.crm.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;

    public boolean sendAppointmentConfirmation(String to, String name) {
        try {
            // Create a context for Thymeleaf
            Context context = new Context();
            context.setVariable("name", name);

            // Generate HTML content from the template located in "emailTemplate/appointmentEmail.html"
            String htmlContent =templateEngine.process("appointmentEmail", context);


            // Create a new email message
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            // Set the recipient, subject, and HTML content of the email
            messageHelper.setFrom("cd9141404@gmail.com");
            messageHelper.setTo(to);
            messageHelper.setSubject("Appointment Confirmation");
            messageHelper.setText(htmlContent, true);

            // Send the email
            emailSender.send(mimeMessage);
            System.out.println("Appointment confirmation email sent to: " + to);
            return true;

        } catch (MessagingException e) {
            System.err.println("Error occurred while sending email to " + to + ": " + e.getMessage());
            return false;
        }
    }
}
