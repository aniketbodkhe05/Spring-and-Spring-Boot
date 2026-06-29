package org.example;

import org.example.notification.EmailService;
import org.example.notification.FakeEmailService;
import org.example.notification.NotificationService;
import org.example.notification.PopUpNotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService notification =new FakeEmailService();
           OrderService orderService= new OrderService(notification);
    orderService.placeOrder();

    }
}