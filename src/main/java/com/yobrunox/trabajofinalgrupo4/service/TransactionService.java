package com.yobrunox.trabajofinalgrupo4.service;
import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionDto;
import com.yobrunox.trabajofinalgrupo4.models.*;
import com.yobrunox.trabajofinalgrupo4.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Transaction transaction = new Transaction(
                transactionDto.getAmount(),
                user,
                booking);

        transaction = transactionRepository.save(transaction);
        updateBookingProgress(booking);

        user.setBalance(user.getBalance()-transaction.getAmount());

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
        booking.setProgress(totalAmount);
        bookingRepository.save(booking);
    }
}
