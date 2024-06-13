package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private String description;
    private LocalDate creationDate;
    private Double financialTargetAmount;
    private Double financialPercentage;
    private Double progress;
    private Integer reservationTypeId;
    private Integer userId;
}
