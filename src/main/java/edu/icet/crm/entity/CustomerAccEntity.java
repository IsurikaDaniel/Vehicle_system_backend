package edu.icet.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "appointmentEntities")
@Entity
@Table(name = "CustomerAcc")
public class CustomerAccEntity {
    @Id
    private String email;

    private String name;
    private String contact;
    private String address;
    private String vehicleType;
    private String vehicleNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customerAcc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentEntity> appointmentEntities;
}
