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

    public Reserv getReservByUser(User user) throws SQLException{
        Reserv reserv = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_RESERV_BY_USER_ID);
        statement.setString(1, String.valueOf(user.getId()));
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            reserv = new Reserv();
            reserv.setId(result.getInt(ColumnNames.RESERVED_ID));
            reserv.setIdProduct(result.getInt(ColumnNames.RESERVED_PRODUCT_ID));
            reserv.setIdUser(result.getInt(ColumnNames.RESERVED_USER_ID));
            reserv.setKol(result.getInt(result.getInt(ColumnNames.RESERVED_PRODUCT_KOL)));
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
