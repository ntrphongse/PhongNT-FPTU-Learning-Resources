/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hd
 * Your code here. Do not delete this comment
 */

public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con = null;
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=FoodManagement;instanceName=PhongNT";
        con = DriverManager.getConnection(url, "sa", "ngtrphong290801");
        
        return con;
    }
}
