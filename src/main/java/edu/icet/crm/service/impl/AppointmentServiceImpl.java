package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Appointment> getAll() {
        return List.of();
    }

    @Override
    public void addAppointment(Appointment appointment) {
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

    @Override
    public void deleteAppointmentById(Integer id) {

    }

    @Override
    public Appointment searchAppointmentById(Integer id) {
        return null;
    }

    @Override
    public void updateAppointmentById(Appointment appointment) {

    }
}
