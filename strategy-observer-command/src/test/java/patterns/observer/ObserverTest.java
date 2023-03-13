package patterns.observer;

import org.junit.jupiter.api.Test;
import patterns.service.notification.command.sales.SalesPaymentNotificationCommand;
import patterns.service.notification.command.user.UserPaymentNotificationCommand;
import patterns.service.notification.service.OrderNotificationService;
import patterns.service.notification.service.sales.SalesOrderNotificationService;
import patterns.service.payment.entity.order.Order;
import patterns.service.payment.entity.order.ProductOrder;
import patterns.service.payment.entity.payment.PayPalPayment;
import patterns.service.payment.entity.payment.Payment;
import patterns.service.payment.service.PaymentProcessingService;
import patterns.service.payment.service.strategy.CreditCardPaymentService;
import patterns.service.payment.service.strategy.PayPalPaymentService;
import patterns.service.payment.service.strategy.PaymentServiceStrategy;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ObserverTest {

    @Test
    void assertUserObserverIsCalled() {
        CreditCardPaymentService creditCardPaymentService = new CreditCardPaymentService();
        PayPalPaymentService payPalPaymentService = new PayPalPaymentService();

        UserPaymentNotificationCommand mockedPaymentObserver = mock(UserPaymentNotificationCommand.class);

        OrderNotificationService orderNotificationService = new SalesOrderNotificationService();
        SalesPaymentNotificationCommand salesPaymentObserver = new SalesPaymentNotificationCommand(orderNotificationService);

        payPalPaymentService.addObserver(mockedPaymentObserver);
        payPalPaymentService.addObserver(salesPaymentObserver);

        creditCardPaymentService.addObserver(mockedPaymentObserver);
        creditCardPaymentService.addObserver(salesPaymentObserver);

        List<PaymentServiceStrategy> paymentServiceStrategyList = List.of(creditCardPaymentService, payPalPaymentService);
        PaymentProcessingService paymentProcessingService = new PaymentProcessingService(paymentServiceStrategyList);

        Payment payment = new PayPalPayment("tokensdkhfslakdjhfkshjdfkkjhsdf");
        Order order = new ProductOrder("34", payment, BigDecimal.valueOf(120L));

        paymentProcessingService.processOrder(order);

        verify(mockedPaymentObserver, times(1)).update(any());
    }
}
