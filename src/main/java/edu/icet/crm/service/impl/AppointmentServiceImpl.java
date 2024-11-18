package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.service.AppointmentService;
import edu.icet.crm.service.EmailService;
import jakarta.transaction.Transactional;
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
    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentArrayList = new ArrayList<>();
        repository.findAll().forEach(entity -> {
            appointmentArrayList.add(mapper.map(entity, Appointment.class));
        });
        return appointmentArrayList;
    }


    @Override
    @Transactional
    public void addAppointment(Appointment appointment) {
        if (appointment.getEmail() == null || appointment.getName() == null) {
            logger.error("Email or Name is missing. Cannot send confirmation email.");
            return;
        }

        try {
            // Save the appointment
            AppointmentEntity appointmentEntity = mapper.map(appointment, AppointmentEntity.class);
            repository.save(appointmentEntity);
            logger.info("Appointment saved successfully for {}", appointment.getName());

            // Send confirmation email
            //boolean emailSent = emailService.sendAppointmentConfirmation(appointment.getEmail(), appointment.getName());
//            if (emailSent) {
//                logger.info("Confirmation email sent to {}", appointment.getEmail());
//            } else {
//                logger.warn("Failed to send confirmation email to {}", appointment.getEmail());
//            }
        } catch (Exception e) {
            logger.error("Error occurred while processing appointment for {} with email {}",
                    appointment.getName(), appointment.getEmail(), e);
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
