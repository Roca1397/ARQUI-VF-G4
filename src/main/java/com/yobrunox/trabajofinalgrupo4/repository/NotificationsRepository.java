package com.yobrunox.trabajofinalgrupo4.repository;

import com.yobrunox.trabajofinalgrupo4.dto.User.NotificationsDto;
import com.yobrunox.trabajofinalgrupo4.models.Notifications;
import com.yobrunox.trabajofinalgrupo4.models.ReservationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Integer> {
    @Query("SELECT new com.yobrunox.trabajofinalgrupo4.dto.User.NotificationsDto(n.title, n.message) FROM Notifications n WHERE n.transaction.user.id = :userId")
    List<NotificationsDto> findAllByUserId(Integer userId);
}
