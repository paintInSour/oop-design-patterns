package patterns.service.payment.service.strategy;

import patterns.notification.observer.payment.PaymentObserver;
import patterns.service.payment.entity.order.Order;

public interface PaymentObservable {

    void addObserver(PaymentObserver paymentObserver);
    void notifyObservers(Order order);
}
