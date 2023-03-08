package patterns.prototype.builder.model.account;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountData implements Cloneable{
    private String firstName;
    private String lastName;
    private String email;
    @ToString.Exclude
    private ShipmentAddress shipmentAddress;

    @Override
    public AccountData clone() {
        try {
            AccountData clone = (AccountData) super.clone();
            clone.shipmentAddress = this.getShipmentAddress().clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShipmentAddress implements Cloneable {
        private String city;
        private String country;
        private String streetName;
        private String streetNumber;

        @Override
        public ShipmentAddress clone() {
            try {
                return (ShipmentAddress) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
