package com.example.profileDemo;

import org.springframework.stereotype.Service;

@Service
public class DummyNotificationServiceImpl implements NotificationService{
    @Override
    public String send() {
        return "Here is a dummy notification";
    }
}
