package patterns.service.notification.service;

import patterns.service.payment.entity.order.Order;

public interface OrderNotificationService {
    void sendNotification(Order order);
}
