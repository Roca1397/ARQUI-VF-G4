package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.NotificationsDto;
import com.yobrunox.trabajofinalgrupo4.models.Notifications;
import com.yobrunox.trabajofinalgrupo4.service.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authenticate")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationsController {
    final NotificationsService notificationsService;

    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }
    @GetMapping("/notificaciones/{userId}")
    public List<NotificationsDto> getNotificationsByUserId(@PathVariable Integer userId) {
        return notificationsService.getNotificationsByUserId(userId);
    }
}
