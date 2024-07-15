package hotelsystem;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author billi
 */
public class MY_CONNECTION {
    
    //in this class we will make or connection with the mySQL database
    public Connection createConnection () {
        
        Connection connection = null;
        
        MysqlDataSource mds = new MysqlDataSource();

        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("java_hotel_db");
        
        try {
        connection = mds.getConnection();
        }
        catch (SQLException ex) {
            Logger.getLogger(MY_CONNECTION.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
        
    }
    
}
