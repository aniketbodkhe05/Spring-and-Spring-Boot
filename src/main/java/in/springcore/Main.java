package in.springcore;

import in.springcore.payment.CardPayment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        OrderService order= context.getBean(OrderService.class);
        order.placeorder();

        CardPayment payment = context.getBean(CardPayment.class);
        payment.pay();

        User user = context.getBean(User.class);
        System.out.println(user.getName());

    }
}