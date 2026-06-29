package in.springcore.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  //consider as a primary
public class UPIPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Payng via UPI");
    }
}
