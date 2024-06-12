package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.ReservationTypeDto;
import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionTypeDto;
import com.yobrunox.trabajofinalgrupo4.models.ReservationType;
import com.yobrunox.trabajofinalgrupo4.models.TransactionType;
import com.yobrunox.trabajofinalgrupo4.service.TransactionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/authenticate")
public class TransactionTypeController {
    final TransactionTypeService transactionTypeService;
    public TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }
    @PostMapping("/CrearTipoTransaccion")
    public ResponseEntity<TransactionType> Add (@RequestBody TransactionTypeDto transactionTypeDto) {
        return new ResponseEntity<>(transactionTypeService.Add(transactionTypeDto), HttpStatus.CREATED);
    }
    @GetMapping("/ListaTipoTransaccion")
    public ResponseEntity<List<TransactionTypeDto>> getAll(){
        return new ResponseEntity<>(transactionTypeService.getAll(), HttpStatus.OK);
    }
}
