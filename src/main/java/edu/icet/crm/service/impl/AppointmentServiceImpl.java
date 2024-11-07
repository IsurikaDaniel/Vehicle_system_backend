package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final ModelMapper mapper;

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
        repository.save(mapper.map(appointment, AppointmentEntity.class));
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
