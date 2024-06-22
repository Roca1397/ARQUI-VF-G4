package com.yobrunox.trabajofinalgrupo4.dto.User;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String username;
    private Date registerDate;
    private String address;
    private String phone;
    private Double balance;

}
