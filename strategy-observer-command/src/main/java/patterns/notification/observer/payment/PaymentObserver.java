package patterns.notification.observer.payment;

import patterns.service.payment.entity.order.Order;

public interface PaymentObserver {
    void update(Order payment);
}
