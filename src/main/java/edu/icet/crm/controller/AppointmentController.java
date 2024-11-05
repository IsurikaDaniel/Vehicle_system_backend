package edu.icet.crm.controller;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appointment")
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    final AppointmentService service;

    @GetMapping("/get-all")
    public List<Appointment> getAppointment(){
        return service.getAll();
    }

    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppointment(@RequestBody Appointment appointment){
        service.addAppointment(appointment);
    }
}
