package patterns.service.payment.service.strategy;

import patterns.constant.PaymentType;
import patterns.service.payment.entity.order.Order;

public interface PaymentServiceStrategy {

    String processPayment(Order order);

    public boolean isMatch(PaymentType paymentType);
}
