package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.ReservationTypeDto;
import com.yobrunox.trabajofinalgrupo4.models.ReservationType;
import com.yobrunox.trabajofinalgrupo4.service.ReservationTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReservationTypeController {
    final ReservationTypeService reservationTypeService;

    public ReservationTypeController(ReservationTypeService reservationTypeService) {
        this.reservationTypeService = reservationTypeService;
    }


    @PostMapping("/admin/CrearTipoReserva")
    public ResponseEntity<ReservationType> Add (@RequestBody ReservationTypeDto reservationTypeDto) {
        return new ResponseEntity<>(reservationTypeService.Add(reservationTypeDto), HttpStatus.CREATED);
    }
    @GetMapping("/user/ListaTipoReserva")
    public ResponseEntity<List<ReservationTypeDto>> getAll(){
        return new ResponseEntity<>(reservationTypeService.getAll(), HttpStatus.OK);
    }
}
