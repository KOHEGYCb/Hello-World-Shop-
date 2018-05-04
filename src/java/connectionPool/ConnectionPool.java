package connectionPool;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author dmitry
 */
public class ConnectionPool {

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new Driver());

            String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
            String user = "dmitry";
            String password = "154789";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static class SingletonHolder {

        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }
}
