package com.example.profileDemo;

public class DummyNotificationServiceImpl implements NotificationService{
    @Override
    public String send() {
        return "Here is a dummy notification";
    }
}
