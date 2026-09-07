package com.example.profileDemo;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public String send(){
        return "Here is a notification";
    }
}
