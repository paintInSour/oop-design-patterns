package patterns.service.notification.service.sales;

import patterns.service.notification.service.OrderNotificationService;
import patterns.service.payment.entity.order.Order;

public class SalesOrderNotificationService implements OrderNotificationService {
    @Override
    public void sendNotification(Order order) {
        System.out.println("SALES PLATFORM NOTIFICATION: " + order);
    }
}
