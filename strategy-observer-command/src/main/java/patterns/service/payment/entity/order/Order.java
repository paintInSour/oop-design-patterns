package patterns.service.payment.entity.order;

import patterns.service.payment.entity.payment.Payment;

public interface Order {
    Payment getPayment();
}
