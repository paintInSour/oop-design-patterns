package patterns.service.notification.command.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import patterns.notification.observer.payment.PaymentObserver;
import patterns.service.notification.command.NotificationCommand;
import patterns.service.notification.service.OrderNotificationService;
import patterns.service.payment.entity.order.Order;

@Data
@AllArgsConstructor
public class UserPaymentNotificationCommand implements PaymentObserver, NotificationCommand {
    private OrderNotificationService orderNotificationService;

    @Override
    public void update(Order order) {
        executeNotification(order);
    }

    @Override
    public void executeNotification(Order order) {
        orderNotificationService.sendNotification(order);
    }
}
