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
    private String email;
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String number;
    private LocalDate date;
    private String location;
    private String service;

    public Appointment(String name, String vehicleType, String vehicleNumber, String number, LocalDate date, String location, String service, String email) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.number = number;
        this.date = date;
        this.location = location;
        this.service = service;
        this.email = email;
    }


}
