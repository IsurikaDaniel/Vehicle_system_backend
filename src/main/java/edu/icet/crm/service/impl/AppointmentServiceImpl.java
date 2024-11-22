package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.dto.Email;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.entity.CustomerAccEntity;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.repository.CustomerAccRepository;
import edu.icet.crm.service.AppointmentService;
import edu.icet.crm.service.EmailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final ModelMapper mapper;
    private final EmailService emailService;
    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private CustomerAccRepository customerAccRepository;

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
        logger.debug("Received appointment: {}", appointment);

        if (appointment.getEmail() == null || appointment.getName() == null) {
            logger.error("Email or Name is missing. Cannot proceed with saving the appointment.");
            return;
        }

        Optional<CustomerAccEntity> userOptional = customerAccRepository.findByEmail(appointment.getEmail());
        if (!userOptional.isPresent()) {
            logger.error("User with email {} not found", appointment.getEmail());
            throw new RuntimeException("User not found");
        }
        CustomerAccEntity customerAcc = userOptional.get();

        try {
            AppointmentEntity appointmentEntity = mapper.map(appointment, AppointmentEntity.class);
            appointmentEntity.setCustomerAcc(customerAcc);
            repository.save(appointmentEntity);

            logger.info("Appointment saved successfully for {}", appointment.getName());

            //send a confirmation email
            Email email = new Email(appointment.getEmail(), "Appointment Confirmation", "Your appointment has been scheduled.");
            emailService.sendEmail(email);

        } catch (Exception e) {
            logger.error("Error occurred while processing appointment for {} with email {}",
                    appointment.getName(), appointment.getEmail(), e);
            throw new RuntimeException("Error processing appointment", e);
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
        // Fetch the existing entity from the database
        AppointmentEntity existingEntity = repository.findById(appointment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + appointment.getId() + " not found"));

        // Update the fields of the existing entity with values from the input
        mapper.map(appointment, existingEntity);

        // Save the updated entity
        repository.save(existingEntity);
    }

}


