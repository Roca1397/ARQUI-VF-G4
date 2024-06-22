package com.yobrunox.trabajofinalgrupo4.service;
import com.yobrunox.trabajofinalgrupo4.dto.User.NotificationsDto;
import com.yobrunox.trabajofinalgrupo4.models.Notifications;
import com.yobrunox.trabajofinalgrupo4.models.Transaction;
import com.yobrunox.trabajofinalgrupo4.repository.NotificationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {
    final NotificationsRepository notificationsRepository;

    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }
    public void createNotification(Transaction transaction) {
        if(transaction.getBooking()==null && transaction.getAmount()>0){
        Notifications notification = Notifications.builder()
                .title("Deposito Exitoso")
                .message("Tu deposito de S/." + transaction.getAmount() + " con fecha " + transaction.getDate() + " fue exitoso.")
                .transaction(transaction)
                .build();
        notificationsRepository.save(notification);}
        else if(transaction.getBooking()==null && transaction.getAmount()<0)
        { Notifications notification = Notifications.builder()
                .title("Retiro Exitoso")
                .message("Tu retiro de S/." + transaction.getAmount() + " con fecha " + transaction.getDate() + " fue exitoso.")
                .transaction(transaction)
                .build();
            notificationsRepository.save(notification);}
        else if(transaction.getAmount()<0)
        { Notifications notification = Notifications.builder()
                .title("Pago Exitoso")
                .message("Tu pago de S/." + transaction.getAmount() + " con fecha " + transaction.getDate() + " se realizo correctamente.")
                .transaction(transaction)
                .build();
            notificationsRepository.save(notification);}
        else if(transaction.getAmount()>0)
        { Notifications notification = Notifications.builder()
                .title("Ahorro Exitoso")
                .message("Depositaste " + transaction.getAmount() + " a tu reserva de " + transaction.getBooking().getDescription() )
                .transaction(transaction)
                .build();
            notificationsRepository.save(notification);}
    }
    public List<NotificationsDto> getNotificationsByUserId(Integer userId) {
        return notificationsRepository.findAllByUserId(userId);
    }
}
