package patterns.prototype.builder.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConstantUtil {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static final String RECIPE_HEADER =
            """
            =============================================================================
            |   PRODUCT COMPANY LLC                                                     |
            |   product.company@product.com                                             |
            |                                                                           |
            |   150 Elgin Street, 8th Floor                                             |
            |   Ottawa, ON K2P 1L4                                                      |
            |                                                                           |
            =============================================================================
            """;

    public static final String USER_DEPATURE_ADDRESS = """
                                                                                        
                DESTINATION:                                                           
                %s %s
                %s %s
            """;

    public static final String USER_DATA= """
            =============================================================================
                USER DATA:
                Name: %s
                Email: %s
            =============================================================================
            """;

    public static final String ITEM_LIST_HEADER = """
                ITEMS:
            """;
    public static final String SINGLE_ITEM_INFO = """
                    ---------------------------------------------------------------------
                    Name: %s
                    Price %s
                    ---------------------------------------------------------------------
            """;

    public static final String ITEM_LIST_FOOTER = """
            -----------------------------------------------------------------------------
                SHIPMENT:                    %s
                TAX:                         %s
                TOTAL:                       %s                             
            -----------------------------------------------------------------------------
            """;

    public static final String RECIPE_FOOTER = """
            =============================================================================
            |                        (C) PRODUCT COMPANY LLC 2023                       |
            |                                                                           |
            |               https://www.instagram.com/product-company-llc               |
            |                                                                           |
            =============================================================================
            """;
}
