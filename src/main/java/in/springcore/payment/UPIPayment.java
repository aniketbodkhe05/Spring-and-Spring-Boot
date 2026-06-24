package in.springcore.payment;

import org.springframework.stereotype.Component;

@Component
public class UPIPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Payng via UPI");
    }
}
