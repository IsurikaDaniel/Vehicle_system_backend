package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.service.AppointmentService;
import edu.icet.crm.service.SendEmailService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final ModelMapper mapper;
    private final SendEmailService sendEmailService;
    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);


    @Autowired
    public AppointmentServiceImpl(AppointmentRepository repository, ModelMapper mapper, SendEmailService sendEmailService) {
        this.repository = repository;
        this.mapper = mapper;
        this.sendEmailService = sendEmailService;
    }


    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            appointmentArrayList.add(mapper.map(entity, Appointment.class));
        });
        return appointmentArrayList;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        // Check for null email or name to avoid issues
        if (appointment.getEmail() == null || appointment.getName() == null) {
            logger.error("Email or Name is missing. Cannot send confirmation email.");
            return;  // Early exit if necessary fields are missing
        }

        // Save the appointment
        try {
            repository.save(mapper.map(appointment, AppointmentEntity.class));
        } catch (Exception e) {
            // Handle any exception that may occur during saving
            logger.error("Error occurred while saving appointment for {} with email {}", appointment.getName(), appointment.getEmail(), e);
            return;
        }

        // Get email and name
        String to = appointment.getEmail();
        String name = appointment.getName();

        // Send the booking success email
        try {
            boolean emailSent = sendEmailService.sendAppointmentSuccessEmail(to, name);
            if (!emailSent) {
                // Log failure with a more descriptive message
                logger.error("Failed to send confirmation email to: {}", to);
            } else {
                logger.info("Confirmation email sent successfully to: {}", to);
            }
        } catch (Exception e) {
            // Handle any exception that may occur in the email sending process
            logger.error("Error occurred while sending confirmation email to: {}", to, e);
        }
    }



    @Override
    public void deleteAppointmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Appointment searchAppointmentById(Long id) {
        return mapper.map(repository.findById(id), Appointment.class);
    }

    @Override
    public void updateAppointmentById(Appointment appointment) {
        repository.save(mapper.map(appointment,AppointmentEntity.class));
    }

}
