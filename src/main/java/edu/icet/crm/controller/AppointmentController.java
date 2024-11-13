package edu.icet.crm.controller;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.service.AppointmentService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private static final Logger logger = LoggerFactory.getLogger(Appointment.class);

    @Autowired
    final AppointmentService service;

    @GetMapping("/get-all")
    public List<Appointment> getAppointment(){
        return service.getAll();
    }
    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppointment(@RequestBody Appointment appointment) {
        logger.info("Received request to add appointment: {}", appointment);
        service.addAppointment(appointment);
    }

    @GetMapping("/search-by-id/{id}")
    public Appointment searchAppointmentById(@PathVariable Long id){
        return service.searchAppointmentById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAppointmentById(@PathVariable Long id){
        service.deleteAppointmentById(id);
    }

    @PutMapping("/update-appointment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppointmentById(@RequestBody Appointment appointment){
        service.updateAppointmentById(appointment);
    }

}
