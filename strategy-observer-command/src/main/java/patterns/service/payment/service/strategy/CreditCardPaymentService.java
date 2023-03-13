package patterns.service.payment.service.strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import patterns.constant.PaymentType;
import patterns.notification.observer.payment.PaymentObserver;
import patterns.service.payment.entity.order.Order;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardPaymentService implements PaymentServiceStrategy, PaymentObservable {
    private List<PaymentObserver> paymentObserverList = new ArrayList<>();

    @Override
    public String processPayment(Order order) {
        System.out.printf("PROCESS CREDIT CARD PAYMENT: %s%n", order);
        notifyObservers(order);
        return "CREDIT CARD PAYMENT PROCESSED";
    }

    @Override
    public boolean isMatch(PaymentType paymentType) {
        return PaymentType.CREDIT_CARD == paymentType;
    }

    @Override
    public void addObserver(PaymentObserver paymentObserver) {
        paymentObserverList.add(paymentObserver);
    }

    @Override
    public void notifyObservers(Order order) {
        paymentObserverList.forEach(paymentObserver -> paymentObserver.update(order));
    }


}
