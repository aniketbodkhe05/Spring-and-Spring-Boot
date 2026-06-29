package com.example.demo;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class OrderService {

    PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Palced");
    }
}
