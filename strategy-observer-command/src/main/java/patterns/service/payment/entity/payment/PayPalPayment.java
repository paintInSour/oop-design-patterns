package patterns.service.payment.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import patterns.constant.PaymentType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayPalPayment implements Payment {
    private String transferIdentityToken;

    @Override
    public PaymentType getType() {
        return PaymentType.PAY_PAL;
    }
}
