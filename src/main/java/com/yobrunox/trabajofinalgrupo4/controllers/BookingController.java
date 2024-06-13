package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.BankDto;
import com.yobrunox.trabajofinalgrupo4.dto.User.BookingDto;
import com.yobrunox.trabajofinalgrupo4.models.Booking;
import com.yobrunox.trabajofinalgrupo4.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/authenticate")
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
    @GetMapping("/bookings")
    public List<BookingDto> getBookingsBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return bookingService.getBookingsBetweenDates(startDate, endDate);
    }
    @GetMapping("/bookings/reservationType")
    public List<BookingDto> getBookingsByReservationType(@RequestParam("typeName") String typeName) {
        return bookingService.getBookingsByReservationTypeName(typeName);
    }
}
