package com.yobrunox.trabajofinalgrupo4.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private String nameCity;
    private Integer countryId;
}
