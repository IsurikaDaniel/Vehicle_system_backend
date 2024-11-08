package edu.icet.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAcc {
    private Integer id;
    private String vehicleType;
    private String vehicleNumber;
    private String cheekyNumber;
}
