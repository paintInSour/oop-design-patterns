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
public class PayPalPaymentService implements PaymentServiceStrategy, PaymentObservable {
    private List<PaymentObserver> paymentObserverList = new ArrayList<>();


    @Override
    public String processPayment(Order order) {
        System.out.printf("PROCESS PAY PAL PAYMENT: %s%n", order);
        notifyObservers(order);
        return "PAY PAL PAYMENT PROCESSED";
    }

    @Override
    public boolean isMatch(PaymentType paymentType) {
        return PaymentType.PAY_PAL == paymentType;
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
