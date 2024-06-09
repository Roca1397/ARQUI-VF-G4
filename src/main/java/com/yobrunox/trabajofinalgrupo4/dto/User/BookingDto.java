package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Integer id;
    private String description;
    private Date creationDate;
    private Double financialTargetAmount;
    private Double financialPercentage;
    private Double progress;
    private Integer reservationTypeId;
    private Integer userId;


}
