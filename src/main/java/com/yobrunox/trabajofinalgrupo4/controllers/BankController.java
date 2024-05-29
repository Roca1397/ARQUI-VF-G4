package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.BankDto;
import com.yobrunox.trabajofinalgrupo4.models.Bank;
import com.yobrunox.trabajofinalgrupo4.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/authenticate")

public class BankController {
    final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/CrearBanco")
    public ResponseEntity<Bank> Add (@RequestBody BankDto bankDto) {
        return new ResponseEntity<>(bankService.Add(bankDto), HttpStatus.CREATED);
    }

    @GetMapping("/ListaBanco")
    public ResponseEntity<List<BankDto>> getAll(){
        return new ResponseEntity<>(bankService.getAll(), HttpStatus.OK);
    }
}
