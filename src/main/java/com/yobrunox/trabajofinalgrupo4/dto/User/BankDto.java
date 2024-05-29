package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDto {
    private String nameBank;
    private String addressBank;
    private String phoneBank;
    private Integer cityId;
}
