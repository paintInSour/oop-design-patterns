package patterns.service.notification.service.user;

import patterns.service.notification.service.OrderNotificationService;
import patterns.service.payment.entity.order.Order;

public class UserOrderNotificationService implements OrderNotificationService {
    @Override
    public void sendNotification(Order order) {
        System.out.println("USER PLATFORM NOTIFICATION: " + order);
    }
}
