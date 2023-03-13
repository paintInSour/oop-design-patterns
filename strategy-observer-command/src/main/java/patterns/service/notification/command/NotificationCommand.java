package patterns.service.notification.command;

import patterns.service.payment.entity.order.Order;

public interface NotificationCommand {
    void executeNotification(Order order);
}
