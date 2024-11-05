package edu.icet.crm.service;

import edu.icet.crm.dto.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    void addAppointment(Appointment appointment);
    void deleteAppointmentById(Long id);
    Appointment searchAppointmentById(Long id);
    void updateAppointmentById(Appointment appointment);
}
