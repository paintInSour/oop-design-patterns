package patterns.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.service.payment.entity.order.Order;
import patterns.service.payment.entity.order.ProductOrder;
import patterns.service.payment.entity.payment.CreditCardPayment;
import patterns.service.payment.entity.payment.PayPalPayment;
import patterns.service.payment.entity.payment.Payment;
import patterns.service.payment.service.PaymentProcessingService;
import patterns.service.payment.service.strategy.CreditCardPaymentService;
import patterns.service.payment.service.strategy.PayPalPaymentService;
import patterns.service.payment.service.strategy.PaymentServiceStrategy;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StrategyTest {
    private List<PaymentServiceStrategy> paymentServiceStrategyList = List.of(new CreditCardPaymentService(), new PayPalPaymentService());


    @Test
    public void assertPayPalPaymentProcessing() {
        PaymentProcessingService paymentProcessingService = new PaymentProcessingService(paymentServiceStrategyList);

        Payment payment = new PayPalPayment("tokensdkhfslakdjhfkshjdfkkjhsdf");
        Order order = new ProductOrder("34", payment, BigDecimal.valueOf(120L));

        var result = paymentProcessingService.processOrder(order);
        Assertions.assertEquals(result, "PAY PAL PAYMENT PROCESSED");
    }

    @Test
    public void assertCreditCardPaymentProcessing() {
        PaymentProcessingService paymentProcessingService = new PaymentProcessingService(paymentServiceStrategyList);

        Payment payment = new CreditCardPayment("1235352235235", "visa", "Andrii Sdr", new Date());
        Order order = new ProductOrder("34", payment, BigDecimal.valueOf(120L));

        var result = paymentProcessingService.processOrder(order);
        Assertions.assertEquals(result, "CREDIT CARD PAYMENT PROCESSED");
    }
}
