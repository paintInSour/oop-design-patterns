package patterns.service.payment.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import patterns.service.payment.entity.payment.Payment;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductOrder implements Order {
    private String orderId;
    private Payment payment;
    private BigDecimal price;
}
