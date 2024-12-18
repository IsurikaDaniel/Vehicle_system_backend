package edu.icet.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    private Integer id;
    private String password;
    private String email;
    private String role;

    public Account(String password, String email ,  String role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }



}
