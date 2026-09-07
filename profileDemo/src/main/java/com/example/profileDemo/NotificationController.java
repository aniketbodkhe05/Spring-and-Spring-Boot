package com.example.profileDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService=notificationService;
    }
    @PostMapping
    public ResponseEntity<String> sendNotification(){
       String notification=  notificationService.send();
       return ResponseEntity.ok(notification);
    }
}
