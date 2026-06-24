package in.springcore.payment;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Paying via card");
    }
}
