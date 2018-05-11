package dao;

import beans.Product;
import connectionPool.ConnectionPool;
import enums.ColumnNames;
import enums.SQLRequests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public class ProductDAO {

    private static final ProductDAO INSTANCE = new ProductDAO();

    private ProductDAO() {
    }

    public static ProductDAO getINSTANCE() {
        return INSTANCE;
    }

    public ArrayList<Product> getAllProducts() throws SQLException {

        ArrayList<Product> products = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_PRODUCTS);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Product product = new Product();
            product.setId(result.getInt(ColumnNames.PRODUCT_ID));
            product.setName(result.getString(ColumnNames.PRODUCT_NAME));
            product.setDescription(result.getString(ColumnNames.PRODUCT_DESCRIPTION));
            product.setKol(result.getInt(ColumnNames.PRODUCT_KOL));
            product.setImage(result.getString(ColumnNames.PRODUCT_IMAGE));
            product.setPrice(result.getInt(ColumnNames.PRODUCT_PRICE));
            products.add(product);
        }
        closeJDBC(connection, statement, result);
        return products;
    }

    public Product getProductByName(String name) throws SQLException {
        Product product = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_PRODUCT_BY_NAME);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            product = new Product();
            product.setId(result.getInt(ColumnNames.PRODUCT_ID));
            product.setName(result.getString(ColumnNames.PRODUCT_NAME));
            product.setDescription(result.getString(ColumnNames.PRODUCT_DESCRIPTION));
            product.setKol(result.getInt(ColumnNames.PRODUCT_KOL));
            product.setImage(result.getString(ColumnNames.PRODUCT_IMAGE));
            product.setPrice(result.getInt(ColumnNames.PRODUCT_PRICE));
        }
        closeJDBC(connection, statement, result);
        return product;
    }

    public Product getProductById(int id) throws SQLException {
        Product product = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_PRODUCT_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            product = new Product();
            product.setId(result.getInt(ColumnNames.PRODUCT_ID));
            product.setName(result.getString(ColumnNames.PRODUCT_NAME));
            product.setDescription(result.getString(ColumnNames.PRODUCT_DESCRIPTION));
            product.setKol(result.getInt(ColumnNames.PRODUCT_KOL));
            product.setImage(result.getString(ColumnNames.PRODUCT_IMAGE));
            product.setPrice(result.getInt(ColumnNames.PRODUCT_PRICE));
        }
        closeJDBC(connection, statement, result);
        return product;
    }

    public boolean isNewProduct(String name) throws SQLException {
        boolean isNewProduct = true;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_PRODUCT_BY_NAME);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            isNewProduct = false;
        }
        closeJDBC(connection, statement, result);
        return isNewProduct;
    }

    public void createProduct(Product product) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_PRODUCT);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getKol());
        statement.setString(3, product.getDescription());
        statement.setString(4, product.getImage());
        statement.setInt(5, product.getPrice());
        statement.executeUpdate();
        closeJDBC(connection, statement);
    }

    public void updateProduct(Product product) {

    }

    public void updateProductKol(int id, int newKol) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.CHANGE_PRODUCT_KOL_BY_PRODUCT_ID);
        statement.setInt(1, newKol);
        statement.setInt(2, id);
        statement.executeUpdate();
        closeJDBC(connection, statement);
    }

    private void closeJDBC(Connection connection, PreparedStatement statement, ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
        }
        if (connection != null) {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    private void closeJDBC(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
        }
        if (connection != null) {
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

}
