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
    private String id;
    private String name;
    private String vehicleType;
    private String number;
    private String email;
    private LocalDate date;
    private String location;
    private String service;
}
