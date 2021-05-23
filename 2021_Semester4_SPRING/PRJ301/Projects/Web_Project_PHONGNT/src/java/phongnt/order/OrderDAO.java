/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import phongnt.Utils.DBHelper;
import phongnt.cart.CartObj;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderDAO implements Serializable {
    public boolean createOrder(String name, String address, 
            CartObj cart) 
        throws SQLException, NamingException {
        
        boolean result = false;
        Connection con = null;
        PreparedStatement stmtOrderInfo = null;
        PreparedStatement stmtOrderDetails = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                
                String orderInfo = "INSERT INTO orderInfo "
                        + "(fullname, address) "
                        + "OUTPUT INSERTED.id "
                        + "VALUES (?, ?)";
                
                String orderDetails = "INSERT INTO orderDetails "
                        + "(orderId, productId, quantity) "
                        + "VALUES (?, ?, ?)";
                
                stmtOrderInfo = con.prepareStatement(orderInfo);
                stmtOrderDetails = con.prepareStatement(orderDetails);
                
                con.setAutoCommit(false); // Disable Auto-Commit
                
                // Add Order Info
                stmtOrderInfo.setNString(1, name);
                stmtOrderInfo.setNString(2, address);
                
                rs = stmtOrderInfo.executeQuery();
                if (rs.next()) {
                    int orderId = rs.getInt("id");

                    // Add Order Details
                    stmtOrderDetails.setInt(1, orderId);
                    Map<Integer, Integer> cartList = cart.getCart();
                    Set<Integer> idSey = cartList.keySet();

                    for (Integer id : idSey) {
                        stmtOrderDetails.setInt(2, id);
                        stmtOrderDetails.setInt(3, cartList.get(id));
                        stmtOrderDetails.executeUpdate();
                    }
                }
                con.commit(); // Commit Change to DB
                result = true;
            }
        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
            }
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stmtOrderDetails != null) {
                stmtOrderDetails.close();
            }
            if (stmtOrderInfo != null) {
                stmtOrderInfo.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
