package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Date date;
    private Double amount;
    private Integer transactionTypeId;
    private Integer userId;
    private Integer bookingId;
}
