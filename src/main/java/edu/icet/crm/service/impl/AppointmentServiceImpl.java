package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.service.AppointmentService;
import edu.icet.crm.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final ModelMapper mapper;
    private final EmailService emailService;
    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentArrayList = new ArrayList<>();
        repository.findAll().forEach(entity -> {
            appointmentArrayList.add(mapper.map(entity, Appointment.class));
        });
        return appointmentArrayList;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        // Check for null email or name to avoid issues
        if (appointment.getEmail() == null || appointment.getName() == null) {
            logger.error("Email or Name is missing. Cannot send confirmation email.");
            return;
        }

        // Save the appointment
        try {
            AppointmentEntity appointmentEntity = mapper.map(appointment, AppointmentEntity.class);
            repository.save(appointmentEntity);
            logger.info("Appointment saved successfully for {}", appointment.getName());

            // Use EmailService to send the confirmation email
            emailService.sendAppointmentConfirmation(appointment.getEmail(), appointment.getName());

        } catch (Exception e) {
            logger.error("Error occurred while saving appointment for {} with email {}", appointment.getName(), appointment.getEmail(), e);
        }
    }

    @Override
    public void deleteAppointmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Appointment searchAppointmentById(Long id) {
        return mapper.map(repository.findById(id).orElse(null), Appointment.class);
    }

    @Override
    public void updateAppointmentById(Appointment appointment) {
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

}
