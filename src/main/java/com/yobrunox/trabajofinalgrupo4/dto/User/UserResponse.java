package com.yobrunox.trabajofinalgrupo4.dto.User;

import com.yobrunox.trabajofinalgrupo4.models.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String token;
    private Users user;
}
