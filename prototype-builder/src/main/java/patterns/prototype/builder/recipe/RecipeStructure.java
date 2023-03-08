package patterns.prototype.builder.recipe;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeStructure implements Cloneable {
    private String recipeHeader;
    private String userDestinationAddressHeader;
    private String userData;
    private String recipeItemListHeader;
    private String recipeItemList;
    private String recipeItemListFooter;
    private String recipeFooter;

    public static RecipeStructureBuilder builder() {
        return new RecipeStructureBuilder();
    }

    @Override
    public RecipeStructure clone() {
        try {
            RecipeStructure clone = (RecipeStructure) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    @NoArgsConstructor
    public static class RecipeStructureBuilder {
        private String recipeHeader;
        private String userDestinationAddressHeader;
        private String userData;
        private String recipeItemListHeader;
        private String recipeItemList;
        private String recipeItemListFooter;
        private String recipeFooter;

        public RecipeStructure build() {
            return new RecipeStructure(recipeHeader, userDestinationAddressHeader,
                    userData, recipeItemListHeader, recipeItemList, recipeItemListFooter, recipeFooter);
        }

        public RecipeStructureBuilder recipeHeader(String recipeHeader) {
            this.recipeHeader = recipeHeader;
            return this;
        }

        public RecipeStructureBuilder userDestinationAddressHeader(String userDestinationAddressHeader) {
            this.userDestinationAddressHeader = userDestinationAddressHeader;
            return this;
        }

        public RecipeStructureBuilder userData(String userData) {
            this.userData = userData;
            return this;
        }

        public RecipeStructureBuilder recipeItemListHeader(String recipeItemListHeader) {
            this.recipeItemListHeader = recipeItemListHeader;
            return this;
        }

        public RecipeStructureBuilder recipeItemList(String recipeItemList) {
            this.recipeItemList = recipeItemList;
            return this;
        }

        public RecipeStructureBuilder recipeItemListFooter(String recipeItemListFooter) {
            this.recipeItemListFooter = recipeItemListFooter;
            return this;
        }

        public RecipeStructureBuilder recipeFooter(String recipeFooter) {
            this.recipeFooter = recipeFooter;
            return this;
        }
    }
}
