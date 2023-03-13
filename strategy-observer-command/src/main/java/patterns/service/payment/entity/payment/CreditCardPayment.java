package patterns.service.payment.entity.payment;

import lombok.*;
import patterns.constant.PaymentType;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String paymentProvider;
    private String cardHolderName;
    private Date expirationDate;

    @Override
    public PaymentType getType() {
        return PaymentType.CREDIT_CARD;
    }
}
