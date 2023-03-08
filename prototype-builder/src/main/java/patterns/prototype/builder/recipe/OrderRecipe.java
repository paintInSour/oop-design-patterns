package patterns.prototype.builder.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import patterns.prototype.builder.model.order.OrderData;
import patterns.prototype.builder.prototype.PrototypeModel;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRecipe extends PrototypeModel {
    private OrderData orderData;
    private RecipeStructure recipeStructure;

    public static OrderRecipeBuilder builder() {
        return new OrderRecipeBuilder();
    }

    @Override
    public PrototypeModel clone() {
        return OrderRecipe.builder()
                .orderData(orderData.clone())
                .recipeStructure(recipeStructure.clone())
                .build();
    }

    public static class OrderRecipeBuilder {
        private OrderData orderData;
        private RecipeStructure recipeStructure;

        public OrderRecipeBuilder orderData(OrderData orderData) {
            this.orderData = orderData;
            return this;
        }

        public OrderRecipeBuilder recipeStructure(RecipeStructure recipeStructure) {
            this.recipeStructure = recipeStructure;
            return this;
        }

        public OrderRecipe build() {
            return new OrderRecipe(orderData, recipeStructure);
        }

    }
}
