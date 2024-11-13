package edu.icet.crm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;  // Injecting TemplateEngine
    private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);

    /**
     * Send success appointment email
     * @param to Recipient's email address
     * @param name Recipient's name
     * @return boolean indicating success or failure
     */
    public boolean sendAppointmentSuccessEmail(String to, String name) {
        try {
            // Set up the context for Thymeleaf template
            Context context = new Context();
            context.setVariable("name", name);

            // Process the email template (replace with your actual template)
            String htmlContent = templateEngine.process("appointment_success_email", context);

            // Create MimeMessage
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            // Set email details
            messageHelper.setTo(to);
            messageHelper.setSubject("Appointment Confirmation");
            messageHelper.setText(htmlContent, true);  // true means HTML content

            // Send the email
            emailSender.send(mimeMessage);
            logger.info("Appointment confirmation email sent to: {}", to);
            return true;

        } catch (MessagingException | MailException e) {
            // Log the error and return false
            logger.error("Error occurred while sending success email to: {}", to, e);
            return false;
        }
    }

    /**
     * Send failure appointment email
     * @param to Recipient's email address
     * @param name Recipient's name
     */
    public void sendAppointmentFailureEmail(String to, String name) {
        try {
            // Set up the context for Thymeleaf template
            Context context = new Context();
            context.setVariable("name", name);

            // Process the email template (replace with your actual template)
            String htmlContent = templateEngine.process("appointment_failure_email", context);

            // Create MimeMessage
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            // Set email details
            messageHelper.setTo(to);
            messageHelper.setSubject("Appointment Unsuccessful");
            messageHelper.setText(htmlContent, true);  // true means HTML content

            // Send the email
            emailSender.send(mimeMessage);
            logger.info("Appointment failure email sent to: {}", to);

        } catch (MessagingException | MailException e) {
            // Log the error
            logger.error("Error occurred while sending failure email to: {}", to, e);
        }
    }
}
