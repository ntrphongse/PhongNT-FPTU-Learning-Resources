/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.orderInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.naming.NamingException;
import phongnt.utils.DBHelpers;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderInfoDAO {
    public int addOrder(String username, String address, Timestamp time) 
        throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 1. Connect DB
            con = DBHelpers.makeConnection();
            if (con != null) {
                // 2. Create SQL String
                String sql = "INSERT INTO orderInfo (username, address, timestamp) "
                        + "VALUES (?, ?, ?)";
                // 3. Create Statement & Assign Paramaters' values
                stmt = con.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, address);
                stmt.setTimestamp(3, time);
                // 4. Execute Query
                int row = stmt.executeUpdate();
                // 5. Process rs
                if (row > 0) {
                    sql = "SELECT TOP 1 id FROM orderInfo ORDER BY id DESC ";
                    stmt = con.prepareStatement(sql);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        return rs.getInt("id");
                    }
                }
            } // EndIf con is connected
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con!= null) {
                con.close();
            }
        }
        return 0;
    }
}
