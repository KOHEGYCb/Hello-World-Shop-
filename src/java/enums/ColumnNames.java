package enums;

/**
 *
 * @author dmitry
 */
public class ColumnNames {
    
    public static final String USER_ID = "id_user";
    public static final String USER_NAME = "name_user";
    public static final String USER_PASSWORD = "password_user";
    public static final String USER_SURNAME = "surname_user";
    public static final String USER_EMAIL = "email_user";
    public static final String USER_ROLE = "role_user";
    
    public static final String PRODUCT_ID = "id_product";
    public static final String PRODUCT_NAME = "name_product";
    public static final String PRODUCT_DESCRIPTION = "description_product";
    public static final String PRODUCT_KOL = "kol_product";
    public static final String PRODUCT_IMAGE = "image_product";    
    public static final String PRODUCT_PRICE = "price_product";

    public static final String RESERVED_ID = "id_reserved";
    public static final String RESERVED_USER_ID = "id_user";
    public static final String RESERVED_PRODUCT_ID = "id_product";
    public static final String RESERVED_PRODUCT_KOL = "kol_product";
    
    public static final String SUM_KOL_PRODUCTS = "sum(kol_product)";
    
    private ColumnNames(){}
}
