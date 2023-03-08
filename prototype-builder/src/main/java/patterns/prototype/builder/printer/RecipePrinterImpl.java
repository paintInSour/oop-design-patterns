package patterns.prototype.builder.printer;

import patterns.prototype.builder.constant.ConstantUtil;
import patterns.prototype.builder.recipe.OrderRecipe;

import java.util.stream.Collectors;

public class RecipePrinterImpl implements RecipePrinter {

    @Override
    public void print(OrderRecipe orderRecipe) {
        var recipeStructure = orderRecipe.getRecipeStructure();
        var address = orderRecipe.getOrderData().getAccountData().getShipmentAddress();
        var userData = orderRecipe.getOrderData().getAccountData();


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(recipeStructure.getRecipeHeader())
                .append(ConstantUtil.LINE_SEPARATOR)
                .append(String.format(recipeStructure.getUserDestinationAddressHeader(), address.getCountry(),
                        address.getCity(), address.getStreetName(), address.getStreetNumber()))
                .append(ConstantUtil.LINE_SEPARATOR)
                .append(String.format(recipeStructure.getUserData(), userData.getFirstName() + " " + userData.getLastName(), userData.getEmail()))
                .append(ConstantUtil.LINE_SEPARATOR)
                .append(recipeStructure.getRecipeItemListHeader())
                .append(ConstantUtil.LINE_SEPARATOR)
                .append(composeItemList(orderRecipe))
                .append(ConstantUtil.LINE_SEPARATOR)
                .append(String.format(recipeStructure.getRecipeItemListFooter(), orderRecipe.getOrderData().getShipmentPrice(),
                        orderRecipe.getOrderData().getTax(), orderRecipe.getOrderData().getTotalPrice()))
                .append(ConstantUtil.LINE_SEPARATOR)
                .append(recipeStructure.getRecipeFooter());

        System.out.println(stringBuilder);

    }

    private String composeItemList(OrderRecipe orderRecipe) {
        return orderRecipe.getOrderData().getItemList().stream()
                .map(item -> String.format(orderRecipe.getRecipeStructure().getRecipeItemList(), item.getName(), item.getPrice()))
                .collect(Collectors.joining(ConstantUtil.LINE_SEPARATOR));
    }
}
