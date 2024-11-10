package edu.icet.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAcc {
    private Integer id;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String vehicleType;
    private String vehicleNumber;

    public CustomerAcc(String name, String contact, String email, String address, String vehicleType, String vehicleNumber) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }


}
