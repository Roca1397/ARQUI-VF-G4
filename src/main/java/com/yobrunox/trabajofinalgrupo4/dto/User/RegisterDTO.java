package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String username;
    private String password;
    private String address;
    private String phone;
    private Integer cityId;
}
