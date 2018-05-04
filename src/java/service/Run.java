package service;

import connectionPool.ConnectionPool;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitry
 */
public class Run {
    public static void main(String[] args) {
        
        Connection connection = null;
        
        try{
            connection = ConnectionPool.getInstance().getConnection();
            System.out.println("Connection yes");
        } catch (SQLException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}
