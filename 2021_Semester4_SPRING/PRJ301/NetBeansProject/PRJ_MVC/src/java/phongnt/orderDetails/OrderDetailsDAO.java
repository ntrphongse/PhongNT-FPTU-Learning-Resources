/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.orderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import phongnt.utils.DBHelpers;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderDetailsDAO {
    public boolean addOrderDetails(int orderId, int productId, int quantity) 
        throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            // 1. Connect DB
            con = DBHelpers.makeConnection();
            if (con != null) {
                // 2. Create SQL String
                String sql = "INSERT INTO orderDetails (orderId, productId, quantity) "
                        + "VALUES (?, ?, ?)";
                // 3. Create Statement & Assign Paramaters' values
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, orderId);
                stmt.setInt(2, productId);
                stmt.setInt(3, quantity);
                // 4. Execute Query
                int row = stmt.executeUpdate();
                // 5. Process rs
                if (row > 0) {
                    return true;
                }
            } // EndIf con is connected
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con!= null) {
                con.close();
            }
        }
        return false;
    }
}
