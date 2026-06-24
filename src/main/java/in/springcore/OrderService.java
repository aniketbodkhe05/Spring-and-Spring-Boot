package in.springcore;

import org.springframework.stereotype.Component;


@Component
public class OrderService {
    //private PaymentService paymentService;
//
//    public OrderService(PaymentService paymentService){
//        this.paymentService= paymentService;
//    }
    public void placeorder(){
        //paymentService.pay();
        System.out.println("Order Palced");
    }
}
