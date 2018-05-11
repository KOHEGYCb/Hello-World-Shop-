package dao;

import beans.Reserv;
import beans.User;
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
public class CartDAO {
    private static final CartDAO INSTANCE = new CartDAO();

    private CartDAO() {
    }

    public static CartDAO getINSTANCE() {
        return INSTANCE;
    }

    public ArrayList<Reserv> getReservByUserId(int  id) throws SQLException{
        ArrayList<Reserv> reserves = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_RESERV_BY_USER_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            
            Reserv reserv = new Reserv();
            reserv.setId(result.getInt(ColumnNames.RESERVED_ID));
            reserv.setIdProduct(result.getInt(ColumnNames.RESERVED_PRODUCT_ID));
            reserv.setIdUser(result.getInt(ColumnNames.RESERVED_USER_ID));
            reserv.setKol(result.getInt(ColumnNames.RESERVED_PRODUCT_KOL));
            reserves.add(reserv);
        }
        closeJDBC(connection, statement, result);
        return reserves;
    }

    public void deleteReservById(int id) throws SQLException{
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.DELETE_RESERV_BY_ID);
        statement.setInt(1, id);
        statement.executeUpdate();
        closeJDBC(connection, statement);
    }
    
    public int getKolProductsCartByUserId(int id) throws SQLException{
        int kol = 0;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_SUM_KOL_PRODUCTS);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            kol = result.getInt(ColumnNames.SUM_KOL_PRODUCTS);
        }
        closeJDBC(connection, statement, result);
        return kol;
    }
    
    public Reserv getReservById(int id) throws SQLException {
        Reserv reserv = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_RESERV_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            
            reserv = new Reserv();
            reserv.setId(result.getInt(ColumnNames.RESERVED_ID));
            reserv.setIdProduct(result.getInt(ColumnNames.RESERVED_PRODUCT_ID));
            reserv.setIdUser(result.getInt(ColumnNames.RESERVED_USER_ID));
            reserv.setKol(result.getInt(ColumnNames.RESERVED_PRODUCT_KOL));
        }
        closeJDBC(connection, statement, result);
        return reserv;
    }
    
    public void createReserv(Reserv reserv) throws SQLException{
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_RESERV);
        statement.setInt(1, reserv.getIdProduct());
        statement.setInt(2, reserv.getIdUser());
        statement.setInt(3, reserv.getKol());
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
