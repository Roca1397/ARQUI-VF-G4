package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.LoginDTO;
import com.yobrunox.trabajofinalgrupo4.dto.User.RegisterDTO;
import com.yobrunox.trabajofinalgrupo4.dto.User.UserResponse;
import com.yobrunox.trabajofinalgrupo4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/Actualizar/{id}")
    public ResponseEntity<RegisterDTO> actualizarDatosUsuario(
            @PathVariable Integer id,
            @RequestBody RegisterDTO registerDTO) {
        RegisterDTO updatedUser = userService.actualizarDatosUsuario(id, registerDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/Deposito/{userId}")
    public ResponseEntity<String> deposit(@PathVariable Integer userId, @RequestParam Double amount) {
        try {
            userService.deposit(userId, amount);
            return ResponseEntity.ok("Depósito realizado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
