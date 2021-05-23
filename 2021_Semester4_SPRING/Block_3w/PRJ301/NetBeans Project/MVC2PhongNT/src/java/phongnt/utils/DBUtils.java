/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.utils;

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
public class DBUtils {
//    public static Connection getConnection() 
//        throws ClassNotFoundException, SQLException {
//        
//        Connection con = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagement;instanceName=PhongNT";
//        
//        con = DriverManager.getConnection(url, "sa", "ngtrphong290801");
//        return con;
//    }
    public static Connection getConnection() 
        throws NamingException, SQLException {
        Connection con = null;
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DSPhongNT");
        
        con = ds.getConnection();
        return con;
    }
}
