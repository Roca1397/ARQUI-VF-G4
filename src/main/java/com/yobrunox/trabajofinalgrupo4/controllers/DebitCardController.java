package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.DebitCardDto;
import com.yobrunox.trabajofinalgrupo4.models.DebitCard;
import com.yobrunox.trabajofinalgrupo4.service.DebitCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class DebitCardController {
    final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @PostMapping("/user/CrearTarjetaDebito")
    public ResponseEntity<DebitCard> Add (@RequestBody DebitCardDto debitCardDto) {
        return new ResponseEntity<>(debitCardService.Add(debitCardDto), HttpStatus.CREATED);
    }

    @GetMapping("/admin/ListaTarjetaDebito")
    public ResponseEntity<List<DebitCardDto>> getAll(){
        return new ResponseEntity<>(debitCardService.getAll(), HttpStatus.OK);
    }
}
