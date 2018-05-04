package dao;

import beans.User;
import connectionPool.ConnectionPool;
import enums.ColumnNames;
import enums.SQLRequests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitry
 */
public class UserDAO {

    private static final UserDAO INSTANCE = new UserDAO();

    private UserDAO() {
    }

    public static UserDAO getINSTANCE() {
        return INSTANCE;
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        
        ArrayList<User> users = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_USERS);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            User user = new User();
            user.setId(result.getInt(ColumnNames.USER_ID));
            user.setEmail(result.getString(ColumnNames.USER_EMAIL));
            user.setName(result.getString(ColumnNames.USER_NAME));
            user.setPassword(result.getString(ColumnNames.USER_PASSWORD));
            user.setSurname(result.getString(ColumnNames.USER_SURNAME));
            user.setRole(result.getInt(ColumnNames.USER_ROLE));
            users.add(user);
        }
        closeJDBC(connection, statement, result);
        ConnectionPool.getInstance().releaseConnection(connection);
        return users;
    }

    public User getUserByEmail(String email) throws SQLException {
        User user = null;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_USER_BY_EMAIL);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            user = new User();
            user.setId(result.getInt(ColumnNames.USER_ID));
            user.setEmail(result.getString(ColumnNames.USER_EMAIL));
            user.setName(result.getString(ColumnNames.USER_NAME));
            user.setPassword(result.getString(ColumnNames.USER_PASSWORD));
            user.setSurname(result.getString(ColumnNames.USER_SURNAME));
            user.setRole(result.getInt(ColumnNames.USER_ROLE));
        }
        closeJDBC(connection, statement, result);
        return user;
    }

    public boolean isNewUser(String email) throws SQLException {
        boolean isNewUser = true;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_USER_BY_EMAIL);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            isNewUser = false;
        }
        closeJDBC(connection, statement, result);
        return isNewUser;
    }

    public boolean isTruePassword(String email, String password) throws SQLException {
        boolean isTruePassword = false;
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.CHECK_AUTHORIZATION);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            isTruePassword = true;
        }
        closeJDBC(connection, statement, result);
        return isTruePassword;
    }

    public void createUser(User user) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_USER);
        statement.setString(1, user.getName());
        statement.setString(2, user.getSurname());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getEmail());
        statement.setInt(5, user.getRole());
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
