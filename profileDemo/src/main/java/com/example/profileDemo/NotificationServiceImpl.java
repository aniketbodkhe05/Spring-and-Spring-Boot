package com.example.profileDemo;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Override
    public String send() {
        return "Here is a notification";
    }
}
