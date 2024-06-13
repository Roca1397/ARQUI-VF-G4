package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionDto;
import com.yobrunox.trabajofinalgrupo4.models.Transaction;
import com.yobrunox.trabajofinalgrupo4.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authenticate")
public class TransactionController {
    final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("/CrearTransaccion/{userId}/{bookingId}")
    public ResponseEntity<?> addTransaction(
            @PathVariable Integer userId,
            @PathVariable Integer bookingId,
            @RequestBody TransactionDto transactionDto) {
        try {
            TransactionDto createdTransaction = transactionService.addTransaction(userId, bookingId, transactionDto);
            return ResponseEntity.ok(createdTransaction);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    /*
    public ResponseEntity<TransactionDto> addTransaction(
            @PathVariable Integer userId,
            @PathVariable Integer bookingId,
            @RequestBody TransactionDto transactionDto) {
        try {
        TransactionDto createdTransaction = transactionService.addTransaction(userId, bookingId, transactionDto);
        return ResponseEntity.ok(createdTransaction);}
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/

}
