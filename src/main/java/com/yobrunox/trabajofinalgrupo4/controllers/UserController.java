package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.UserDTO;
import com.yobrunox.trabajofinalgrupo4.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
        //return new ResponseEntity(userService.getBalance(id), HttpStatus.OK);
    }

    @GetMapping("/getBalance/{id}")
    public ResponseEntity<Double> getBalance(@PathVariable Integer id){
        return new ResponseEntity(userService.getBalance(id), HttpStatus.OK);
    }
}
