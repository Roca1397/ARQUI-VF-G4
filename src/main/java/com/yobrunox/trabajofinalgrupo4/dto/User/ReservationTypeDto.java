package com.yobrunox.trabajofinalgrupo4.dto.User;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationTypeDto {
    private String name;
    private String description;
}
