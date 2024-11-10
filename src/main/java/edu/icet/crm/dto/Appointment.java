package edu.icet.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    private Long id;
    private String name;
    private String vehicleType;
    private String number;
    private String email;
    private LocalDate date;
    private String location;
    private String service;

    public Appointment(String name, String vehicleType, String number, String email, LocalDate date, String location, String service) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.number = number;
        this.email = email;
        this.date = date;
        this.location = location;
        this.service = service;
    }

}
