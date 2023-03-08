package patterns.prototype.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import patterns.prototype.builder.constant.PrototypeType;
import patterns.prototype.builder.model.account.AccountData;
import patterns.prototype.builder.model.item.Item;
import patterns.prototype.builder.model.order.OrderData;
import patterns.prototype.builder.printer.RecipePrinterImpl;
import patterns.prototype.builder.prototype.PrototypeModel;
import patterns.prototype.builder.recipe.OrderRecipe;
import patterns.prototype.builder.service.PrototypeModelManager;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class PrototypeTest {

    @Test
    public void assertGenerateRecipe() {
        AccountData.ShipmentAddress shipmentAddress = new AccountData.ShipmentAddress("Khmelnytsky", "Ukraine", "Instytuts'ka St", "11");

        AccountData accountData = new AccountData("Andrii", "Shudryk", "andr.sdr@gmail.com", shipmentAddress);
        List<Item> itemList = List.of(new Item("Some item name", "", BigDecimal.valueOf(22.45), 10L));
        OrderData orderData = new OrderData(accountData, itemList, BigDecimal.valueOf(1.15), BigDecimal.valueOf(5), BigDecimal.valueOf(28.60));

        PrototypeModel prototype = PrototypeModelManager.getPrototype(PrototypeType.RECIPE);
        OrderRecipe orderRecipe = (OrderRecipe) prototype;
        orderRecipe.setOrderData(orderData);

        RecipePrinterImpl recipePrinter = new RecipePrinterImpl();
        recipePrinter.print(orderRecipe);
    }

    @Test
    public void assertBuilder() {
        AccountData.ShipmentAddress shipmentAddress = new AccountData.ShipmentAddress("Khmelnytsky", "Ukraine", "Instytuts'ka St", "11");

        AccountData accountData = new AccountData("Andrii", "Shudryk", "andr.sdr@gmail.com", shipmentAddress);
        List<Item> itemList = List.of(new Item("Some item name", "", BigDecimal.valueOf(22.45), 10L));
        OrderData orderData = new OrderData(accountData, itemList, BigDecimal.valueOf(1.15), BigDecimal.valueOf(5), BigDecimal.valueOf(28.60));

        OrderRecipe orderRecipe = OrderRecipe.builder()
                .orderData(orderData)
                .build();

        Assertions.assertEquals(orderRecipe.getOrderData(), orderData);
        Assertions.assertNull(orderRecipe.getRecipeStructure());
    }

    @Test
    public void assertCloneWorksProperly() {
        AccountData.ShipmentAddress shipmentAddress = new AccountData.ShipmentAddress("Khmelnytsky", "Ukraine", "Instytuts'ka St", "11");

        AccountData accountData = new AccountData("Andrii", "Shudryk", "andr.sdr@gmail.com", shipmentAddress);
        List<Item> itemList = List.of(new Item("Some item name", "", BigDecimal.valueOf(22.45), 10L));
        OrderData orderData = new OrderData(accountData, itemList, BigDecimal.valueOf(1.15), BigDecimal.valueOf(5), BigDecimal.valueOf(28.60));

        PrototypeModel prototype = PrototypeModelManager.getPrototype(PrototypeType.RECIPE);
        OrderRecipe orderRecipe = (OrderRecipe) prototype;
        orderRecipe.setOrderData(orderData);

        PrototypeModel prototype2 = PrototypeModelManager.getPrototype(PrototypeType.RECIPE);
        OrderRecipe orderRecipe1 = (OrderRecipe) prototype2;

        AccountData accountData1 = new AccountData("Someone", "Else", "", shipmentAddress);
        orderRecipe1.getOrderData().setAccountData(accountData1);

        Assertions.assertNotEquals(orderRecipe1.getOrderData().getAccountData(), orderRecipe.getOrderData().getAccountData());

    }
}
