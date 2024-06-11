package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.BookingDto;
import com.yobrunox.trabajofinalgrupo4.models.*;
import com.yobrunox.trabajofinalgrupo4.repository.*;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    final TransactionRepository transactionRepository;
    final UserRepository userRepository;
    final BookingRepository bookingRepository;
    final TransactionTypeRepository transactionTypeRepository;
    final NotificationsRepository notificationsRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, BookingRepository bookingRepository, TransactionTypeRepository transactionTypeRepository, NotificationsRepository notificationsRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.transactionTypeRepository = transactionTypeRepository;
        this.notificationsRepository = notificationsRepository;
    }
/*
    public Transaction Add (BookingDto bookingDto) {
        ReservationType reservationType = new ReservationType();
        reservationType.setId(bookingDto.getReservationTypeId());
        Users users = new Users();
        users.setId(bookingDto.getUserId());
        users.setRole(Role.USER);
        Booking booking = new Booking(bookingDto.getDescription(),bookingDto.getCreationDate(),bookingDto.getFinancialTargetAmount(),
                bookingDto.getFinancialPercentage(),bookingDto.getProgress(),reservationType,users);
        return bookingRepository.save(booking);
    }*/


}
