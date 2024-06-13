package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.BookingDto;
import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionDto;
import com.yobrunox.trabajofinalgrupo4.models.*;
import com.yobrunox.trabajofinalgrupo4.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {
    final TransactionRepository transactionRepository;
    final UserRepository userRepository;
    final BookingRepository bookingRepository;
    final NotificationsRepository notificationsRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, BookingRepository bookingRepository, NotificationsRepository notificationsRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.notificationsRepository = notificationsRepository;
    }
/*
    public Transaction Add (TransactionDto transactionDto) {
        TransactionType transactionType = new TransactionType();
        transactionType.setId(transactionDto.getTransactionTypeId());
        Users users = new Users();
        users.setId(transactionDto.getUserId());
        Booking booking= new Booking();
        booking.setId(transactionDto.getBookingId());
        Transaction transaction = new Transaction(transactionDto.getDate(),transactionDto.getAmount(),users,booking,transactionType);
        return transactionRepository.save(transaction);
    }*/
public Transaction addTransaction(Integer userId, Integer bookingId, TransactionDto transactionDto) {
    Users user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + userId));

    Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + bookingId));
    Transaction transaction = new Transaction(
            transactionDto.getDate(),
            transactionDto.getAmount(),
            user,
            booking
    );

    return transactionRepository.save(transaction);
}
}
