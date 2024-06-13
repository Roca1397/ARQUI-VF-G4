package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.BookingDto;
import com.yobrunox.trabajofinalgrupo4.models.Booking;
import com.yobrunox.trabajofinalgrupo4.models.ReservationType;
import com.yobrunox.trabajofinalgrupo4.models.Role;
import com.yobrunox.trabajofinalgrupo4.models.Users;
import com.yobrunox.trabajofinalgrupo4.repository.BookingRepository;
import com.yobrunox.trabajofinalgrupo4.repository.ReservationTypeRepository;
import com.yobrunox.trabajofinalgrupo4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    final BookingRepository bookingRepository;
    final UserRepository userRepository;
    final ReservationTypeRepository reservationTypeRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, ReservationTypeRepository reservationTypeRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.reservationTypeRepository = reservationTypeRepository;
    }

    public Booking Add(BookingDto bookingDto) {
        ReservationType reservationType = new ReservationType();
        reservationType.setId(bookingDto.getReservationTypeId());
        Users users = new Users();
        users.setId(bookingDto.getUserId());
        users.setRole(Role.USER);
        Booking booking = new Booking(bookingDto.getDescription(), bookingDto.getFinancialTargetAmount(),
                bookingDto.getFinancialPercentage(), bookingDto.getProgress(), reservationType, users);
        return bookingRepository.save(booking);
    }

    public java.util.List<BookingDto> getAll() {
        java.util.List<Booking> lista = bookingRepository.findAll();
        List<BookingDto> listaDto = new ArrayList<>();
        BookingDto item;
        for (Booking b : lista) {
            item = new BookingDto(b.getDescription(), b.getCreationDate(), b.getFinancialTargetAmount(), b.getFinancialPercentage()
                    , b.getProgress(), b.getReservationType().getId(), b.getUser().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
    public List<BookingDto> getBookingsByReservationTypeName(String typeName) {
        List<Booking> bookings = bookingRepository.findBookingsByReservationTypeName(typeName);
        return convertToBookingDtoList(bookings);
    }

    public List<BookingDto> getBookingsBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<Booking> bookings = bookingRepository.findBookingsBetweenDates(startDate, endDate);
        return convertToBookingDtoList(bookings);
    }

    private List<BookingDto> convertToBookingDtoList(List<Booking> bookings) {
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDto bookingDto = new BookingDto(
                    booking.getDescription(),
                    booking.getCreationDate(),
                    booking.getFinancialTargetAmount(),
                    booking.getFinancialPercentage(),
                    booking.getProgress(),
                    booking.getReservationType().getId(),
                    booking.getUser().getId()
            );
            bookingDtos.add(bookingDto);
        }
        return bookingDtos;
    }
}
