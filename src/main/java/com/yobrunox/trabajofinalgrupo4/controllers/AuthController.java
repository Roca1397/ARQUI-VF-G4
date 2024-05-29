package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.LoginDTO;
import com.yobrunox.trabajofinalgrupo4.dto.User.RegisterDTO;
import com.yobrunox.trabajofinalgrupo4.dto.User.UserResponse;
import com.yobrunox.trabajofinalgrupo4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("api/authenticate")

public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(userService.register(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(userService.login(loginDTO));
    }
}
