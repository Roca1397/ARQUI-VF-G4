package com.yobrunox.trabajofinalgrupo4.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCardDto {
    private String numberCard;
    private LocalDate expirationDate;
    private Integer cvv;
    private String password;
    private Integer bankId;
    private Integer userId;

}
