package enums;

/**
 *
 * @author dmitry
 */
public class SQLRequests {

    public static final String GET_ALL_USERS = "SELECT * FROM shop.Users;";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM shop.Users WHERE email_user = ?";
    public static final String CHECK_AUTHORIZATION = "SELECT email_user, password_user FROM shop.Users WHERE email_user = ? AND password_user = ?";
    public static final String ADD_USER = "INSERT INTO shop.Users(name_user, surname_user, password_user, email_user, role_user) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_ALL_PRODUCTS = "SELECT * FROM shop.product";
    public static final String GET_PRODUCT_BY_NAME = "SELECT * FROM shop.product WHERE name_product = ?";
    public static final String ADD_PRODUCT = "INSERT INTO shop.product (name_product, kol_product, description_product, image_product, price_product) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_RESERV_BY_USER_ID = "SELECT * FROM shop.reserved WHERE id_user = ?";
    public static final String ADD_RESERV = "INSERT INTO shop.reserved (id_product, id_user, kol_product) VALUES (?, ?, ?)";
    public static final String CHANGE_PRODUCT_KOL_BY_PRODUCT_ID = "UPDATE shop.product SET kol_product=? where id_product=?";    
    public static final String GET_PRODUCT_BY_ID = "SELECT * FROM shop.product WHERE id_product = ?";

}
