package edu.icet.crm.controller;

import edu.icet.crm.dto.ApiResponse;
import edu.icet.crm.dto.Appointment;
import edu.icet.crm.service.AppointmentService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private static final Logger logger = LoggerFactory.getLogger(Appointment.class);
    private final AppointmentService appointmentService;

    @Autowired
    final AppointmentService service;

    @GetMapping("/get-all")
    public List<Appointment> getAppointment(){
        return service.getAll();
    }

    @PostMapping("/add-appointment")
    public ResponseEntity<ApiResponse> addAppointment(@RequestBody Appointment appointment) {
        try {
            appointmentService.addAppointment(appointment);
            return ResponseEntity.ok(new ApiResponse("200", "Appointment added successfully.", true));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("400", "Failed to add appointment: " + e.getMessage(), false));
        }
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
