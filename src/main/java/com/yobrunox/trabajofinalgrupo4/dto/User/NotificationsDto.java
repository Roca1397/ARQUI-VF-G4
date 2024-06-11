package com.yobrunox.trabajofinalgrupo4.dto.User;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationsDto {
    private String title;
    private String message;
}
