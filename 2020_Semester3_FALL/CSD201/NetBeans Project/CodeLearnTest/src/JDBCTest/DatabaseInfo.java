/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCTest;


/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DatabaseInfo {
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

//localhost:<PORT>  databaseName=<Tên của database vừa tạo>
    public static String dbURL = "jdbc:sqlserver://localhost:1443;databaseName=FUH_COMPANY";

//Username và Password chừa trống, trong phần mềm sẽ nhập sau
    public static String dbUser = "sa";
    public static String dbPass = "ngtrphong290801";
    
    
}
