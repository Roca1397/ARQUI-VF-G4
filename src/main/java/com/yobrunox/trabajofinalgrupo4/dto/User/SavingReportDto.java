package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingReportDto {
    private String bookingDescription;
    private LocalDate transactionDate;
    private Double transactionAmount;
}
