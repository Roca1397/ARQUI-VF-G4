package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.SavingReportDto;
import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionDto;
import com.yobrunox.trabajofinalgrupo4.models.Transaction;
import com.yobrunox.trabajofinalgrupo4.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    @PostMapping("/Deposito/{userId}")
    public ResponseEntity<String> deposit(@PathVariable Integer userId, @RequestParam Double amount) {
        try {
            transactionService.deposit(userId, amount);
            return ResponseEntity.ok("Depósito realizado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/Retiro/{userId}")
    public ResponseEntity<String> withdraw(@PathVariable Integer userId, @RequestParam Double amount,
                                           @RequestParam(defaultValue = "true") boolean saldo,
                                           @RequestParam(required = false) Integer bookingId) {
        try {
            transactionService.withdraw(userId, amount, saldo, bookingId);
            return ResponseEntity.ok("Retiro realizado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/reporteAhorro/{userId}")
    public List<SavingReportDto> Ahorro(
            @PathVariable("userId") Integer userId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Integer reservationTypeId = 1;
        return transactionService.Reporte(reservationTypeId, userId, startDate, endDate);
    }
    @GetMapping("/reporteGastos/{userId}")
    public List<SavingReportDto> Gasto(
            @PathVariable("userId") Integer userId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Integer reservationTypeId = 2;
        return transactionService.Reporte(reservationTypeId, userId, startDate, endDate);
    }

}
