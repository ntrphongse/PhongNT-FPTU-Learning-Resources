/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Hp
 */
public class DBHelpers implements Serializable {
    public static Connection makeConnection()
        throws /* ClassNotFoundException */ NamingException, SQLException {
        
//        // 1. Load Driver --> Add driver into project
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//        // 2. Create Connection String to determine Container address
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=PhongNT;instanceName=PHONGNT";
//
//        // 3. Open Connection
//        Connection con = DriverManager.getConnection(url, "sa", "ngtrphong290801");
//        
//        return con;
        Context currentContext = new InitialContext();
        Context tomcatContext = (Context)currentContext.lookup("java:comp/env");
        DataSource ds = (DataSource)tomcatContext.lookup("DS007");
        Connection con = ds.getConnection();
        
        return con;
        
    }
}
