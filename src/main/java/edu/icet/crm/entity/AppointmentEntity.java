package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String vehicleType;
    private String number;
    private String email;
    private LocalDate date;
    private String location;
    private String service;
}
