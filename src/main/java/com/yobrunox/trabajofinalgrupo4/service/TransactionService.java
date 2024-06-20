package com.yobrunox.trabajofinalgrupo4.service;
import com.yobrunox.trabajofinalgrupo4.dto.User.SavingReportDto;
import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionDto;
import com.yobrunox.trabajofinalgrupo4.models.*;
import com.yobrunox.trabajofinalgrupo4.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional
    public TransactionDto addTransaction(Integer userId, Integer bookingId, TransactionDto transactionDto) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + userId));
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + bookingId));
        Double amount = transactionDto.getAmount();
        if (user.getBalance() < amount) {
            throw new RuntimeException("Saldo insuficiente para realizar la transacción.");
        }
        Double transactionAmount = transactionDto.getAmount();
        if (booking.getReservationType().getId()==2) {
            transactionAmount = -transactionAmount;
        }
        Transaction transaction = new Transaction(
                transactionAmount,//transactionDto.getAmount(),
                user,
                booking);

        transaction = transactionRepository.save(transaction);
        updateBookingProgress(booking);


        user.setBalance(user.getBalance()-amount);//transaction.getAmount());

        return TransactionDto.builder()
                .date(transaction.getDate())
                .amount(transaction.getAmount())
                .userId(userId)
                .bookingId(bookingId)
                .build();
    }
    private void updateBookingProgress(Booking booking) {
        Double totalAmount = booking.getTransactions().stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
       /* if (booking.getReservationType().getId()==2) {
            totalAmount = -totalAmount;
        }*/
        booking.setProgress(totalAmount);
        if(booking.getReservationType().getId()==1){
        booking.setFinancialPercentage((booking.getProgress()/booking.getFinancialTargetAmount())*100 );}
        bookingRepository.save(booking);
    }
    @Transactional
    public void deposit(Integer userId, Double amount) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + userId));

        DebitCard debitCard = user.getDebitCard();
        if (debitCard == null) {
            throw new RuntimeException("El usuario no tiene una tarjeta de débito registrada.");
        }

        double newBalance = user.getBalance() + amount;
        user.setBalance(newBalance);

        userRepository.save(user);

        Transaction transaction = new Transaction(amount, user, null);
        transactionRepository.save(transaction);
    }
    @Transactional
    public void withdraw(Integer userId, Double amount, boolean saldo, Integer bookingId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + userId));
        DebitCard debitCard = user.getDebitCard();
        if (debitCard == null) {
            throw new RuntimeException("El usuario no tiene una tarjeta de débito registrada.");
        }
        if (saldo) {
            if (user.getBalance() < amount) {
                throw new RuntimeException("Saldo insuficiente para realizar el retiro.");
            }
            double newBalance = user.getBalance() - amount;
            user.setBalance(newBalance);
            userRepository.save(user);
        }
        else {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + bookingId));
            if (amount > booking.getProgress()) {
                throw new RuntimeException("El monto a retirar excede el ahorro de la reserva.");
            }

            double newProgress = booking.getProgress() - amount;
            booking.setProgress(newProgress);
            bookingRepository.save(booking);
        }

        Transaction transaction = new Transaction(-amount, user, null);
        transactionRepository.save(transaction);
    }
    public List<SavingReportDto> Reporte(Integer reservationTypeId, Integer userId, LocalDate startDate, LocalDate endDate) {
        return transactionRepository.findAllByReservationTypeIdAndUserIdAndDateRange(reservationTypeId, userId, startDate, endDate)
                .stream()
                .map(transaction -> new SavingReportDto(
                        transaction.getBooking().getDescription(),
                        transaction.getDate(),
                        transaction.getAmount()
                ))
                .collect(Collectors.toList());
    }
}
