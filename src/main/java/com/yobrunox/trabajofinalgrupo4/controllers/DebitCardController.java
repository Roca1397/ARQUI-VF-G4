package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.DebitCardDto;
import com.yobrunox.trabajofinalgrupo4.models.DebitCard;
import com.yobrunox.trabajofinalgrupo4.service.DebitCardService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("api/authenticate")
public class DebitCardController {
    final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @PostMapping("/CrearTarjetaDebito")
    public ResponseEntity<DebitCard> Add (@RequestBody DebitCardDto debitCardDto) {
        return new ResponseEntity<>(debitCardService.Add(debitCardDto), HttpStatus.CREATED);
    }

    @GetMapping("/ListaTarjetaDebito")
    public ResponseEntity<List<DebitCardDto>> getAll(){
        return new ResponseEntity<>(debitCardService.getAll(), HttpStatus.OK);
    }
    @PutMapping("/ActualizarTarjetaDebito/{id}")
    public DebitCardDto actualizarDebitCard(
            @PathVariable Integer id,
            @RequestParam String nuevoNumeroCard,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate nuevaFechaExpiracion,
            @RequestParam Integer nuevoCvv,
            @RequestParam String nuevaPassword) {
        return debitCardService.actualizarDatosDebitCard(id, nuevoNumeroCard, nuevaFechaExpiracion, nuevoCvv, nuevaPassword);
    }
}
