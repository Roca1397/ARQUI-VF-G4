package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.BankDto;
import com.yobrunox.trabajofinalgrupo4.dto.User.BookingDto;
import com.yobrunox.trabajofinalgrupo4.models.Booking;
import com.yobrunox.trabajofinalgrupo4.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class BookingController {
    final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/CrearReserva")
    public ResponseEntity<Booking> Add (@RequestBody BookingDto bookingDto) {
        return new ResponseEntity<>(bookingService.Add(bookingDto), HttpStatus.CREATED);
    }

    @GetMapping("/ListaReserva")
    public ResponseEntity<List<BookingDto>> getAll(){
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }
}
