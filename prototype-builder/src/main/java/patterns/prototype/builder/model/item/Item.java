package patterns.prototype.builder.model.item;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Cloneable{
    private String name;
    private String image;
    private BigDecimal price;
    private Long stock;

    @Override
    public Item clone() {
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
