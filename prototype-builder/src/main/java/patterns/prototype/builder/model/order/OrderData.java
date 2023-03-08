package patterns.prototype.builder.model.order;

import lombok.*;
import patterns.prototype.builder.model.account.AccountData;
import patterns.prototype.builder.model.item.Item;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderData implements Cloneable {
    private AccountData accountData;
    private List<Item> itemList;
    private BigDecimal tax;
    private BigDecimal shipmentPrice;
    private BigDecimal totalPrice;

    @Override
    public OrderData clone() {
        try {
            OrderData clone = (OrderData) super.clone();
            clone.setAccountData(this.getAccountData().clone());
            var itemListClone = itemList.stream().map(Item::clone).toList();
            clone.setItemList(itemListClone);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
