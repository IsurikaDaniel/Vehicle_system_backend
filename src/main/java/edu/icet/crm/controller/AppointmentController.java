package edu.icet.crm.controller;

import edu.icet.crm.dto.Appointment;
import edu.icet.crm.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Appointment")
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    final AppointmentService service;

    @GetMapping("/get-all")
    public List<Appointment> getCustomer(){
        return service.getAll();
    }
}
