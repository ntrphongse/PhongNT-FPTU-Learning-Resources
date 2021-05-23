/*
 * Tran Phong's Project
 */
package phongnt.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DBHelper {
    public static Connection createConnection() 
            throws NamingException, SQLException {
//        // 1. Load Driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        
//        // 2. Connection String
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=PhongNT;instanceName=PHONGNT";
//        
//        // 3. Create Connection
//        Connection con = DriverManager.getConnection(url, "sa", "ngtrphong290801");
//        
//        return con;
        
        Context currentContext = new InitialContext();
        Context tomcatContext = (Context) currentContext.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatContext.lookup("SampleDB");
        
        Connection con = ds.getConnection();
        return con;
    }
}
