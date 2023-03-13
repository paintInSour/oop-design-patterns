package patterns.command;

import org.junit.jupiter.api.Test;
import patterns.service.notification.command.user.UserPaymentNotificationCommand;
import patterns.service.notification.service.user.UserOrderNotificationService;
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

public class CommandTest {

    @Test
    void assertNotificationCommandIsExecuted() {
        CreditCardPaymentService creditCardPaymentService = new CreditCardPaymentService();
        PayPalPaymentService payPalPaymentService = new PayPalPaymentService();

        UserOrderNotificationService mockedUserNotificationService = mock(UserOrderNotificationService.class);

        UserPaymentNotificationCommand userPaymentNotificationCommand = new UserPaymentNotificationCommand(mockedUserNotificationService);

        payPalPaymentService.addObserver(userPaymentNotificationCommand);

        List<PaymentServiceStrategy> paymentServiceStrategyList = List.of(creditCardPaymentService, payPalPaymentService);
        PaymentProcessingService paymentProcessingService = new PaymentProcessingService(paymentServiceStrategyList);

        Payment payment = new PayPalPayment("tokensdkhfslakdjhfkshjdfkkjhsdf");
        Order order = new ProductOrder("34", payment, BigDecimal.valueOf(120L));

        paymentProcessingService.processOrder(order);

        verify(mockedUserNotificationService, times(1)).sendNotification(any());
    }
}
