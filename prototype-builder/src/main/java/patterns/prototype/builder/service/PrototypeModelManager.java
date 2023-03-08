package patterns.prototype.builder.service;

import lombok.NoArgsConstructor;
import patterns.prototype.builder.constant.ConstantUtil;
import patterns.prototype.builder.constant.PrototypeType;
import patterns.prototype.builder.model.account.AccountData;
import patterns.prototype.builder.model.order.OrderData;
import patterns.prototype.builder.prototype.PrototypeModel;
import patterns.prototype.builder.recipe.OrderRecipe;
import patterns.prototype.builder.recipe.RecipeStructure;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
public class PrototypeModelManager {
    private static HashMap<PrototypeType, PrototypeModel> prototypeModelHashMap = new HashMap<>();

    static {
        AccountData accountData = new AccountData();
        AccountData.ShipmentAddress shipmentAddress = new AccountData.ShipmentAddress();
        OrderData orderData = new OrderData();
        accountData.setShipmentAddress(shipmentAddress);
        orderData.setAccountData(accountData);
        orderData.setItemList(List.of());
        var defaultRecipe = RecipeStructure.builder()
                .recipeHeader(ConstantUtil.RECIPE_HEADER)
                .userDestinationAddressHeader(ConstantUtil.USER_DEPATURE_ADDRESS)
                .userData(ConstantUtil.USER_DATA)
                .recipeItemListHeader(ConstantUtil.ITEM_LIST_HEADER)
                .recipeItemList(ConstantUtil.SINGLE_ITEM_INFO)
                .recipeItemListFooter(ConstantUtil.ITEM_LIST_FOOTER)
                .recipeFooter(ConstantUtil.RECIPE_FOOTER)
                .build();
        var orderRecipe = OrderRecipe.builder()
                .orderData(orderData)
                .recipeStructure(defaultRecipe)
                .build();
        prototypeModelHashMap.put(PrototypeType.RECIPE, orderRecipe);
    }

    public static PrototypeModel getPrototype(PrototypeType type) {
        return prototypeModelHashMap.get(type).clone();
    }


}
