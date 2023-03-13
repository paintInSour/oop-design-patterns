package patterns.service.payment.service;

import lombok.AllArgsConstructor;
import patterns.service.payment.entity.order.Order;
import patterns.service.payment.service.strategy.PaymentServiceStrategy;

import java.util.List;

@AllArgsConstructor
public class PaymentProcessingService {

    private List<PaymentServiceStrategy> paymentServiceStrategyList;

    public String processOrder(Order order) {
        return paymentServiceStrategyList.stream().filter(paymentServiceStrategy -> paymentServiceStrategy.isMatch(order.getPayment().getType()))
                .findAny()
                .orElseThrow(() -> new RuntimeException(String.format("Not found payment service for order: %s", order)))
                .processPayment(order);
    }
}
