/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ConnectSQLServerExample {
    public static Connection getConnect() throws ClassNotFoundException, SQLException {
	Class.forName(DatabaseInfo.driverName);
	Connection connection = DriverManager.getConnection(DatabaseInfo.dbURL, DatabaseInfo.dbUser, DatabaseInfo.dbPass);
	return connection;
    }
    
    public static void main(String[] args) {
        try {
            Connection connection = getConnect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from tblEmployee");
            while (rs.next()) {
                String SSN = rs.getNString(0);
                System.out.println(SSN);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
