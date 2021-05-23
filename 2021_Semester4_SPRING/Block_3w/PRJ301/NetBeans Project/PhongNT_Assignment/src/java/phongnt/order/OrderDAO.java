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
import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import phongnt.Utils.DBHelper;
import phongnt.cart.CartObj;
import phongnt.cart.CartProductDTO;
import phongnt.tblProducts.TblProductsDAO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderDAO implements Serializable {

    public int createOrder(String userID, String name, String address,
            float total, Timestamp date, CartObj cart)
            throws SQLException, NamingException {

        int result = -1;
        Connection con = null;
        PreparedStatement stmtOrderInfo = null;
        PreparedStatement stmtOrderDetails = null;
        PreparedStatement stmtUpdate = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String orderInfo = "INSERT INTO tblOrders "
                        + "(userID, date, total, fullName, address) "
                        + "OUTPUT INSERTED.orderID "
                        + "VALUES (?, ?, ?, ?, ?)";

                String orderDetails = "INSERT INTO tblOrderDetails "
                        + "(orderID, productID, quantity, price) "
                        + "VALUES (?, ?, ?, ?)";

                stmtOrderInfo = con.prepareStatement(orderInfo);
                stmtOrderDetails = con.prepareStatement(orderDetails);

                con.setAutoCommit(false); // Disable Auto-Commit

                // Add Order Info
                stmtOrderInfo.setString(1, userID);
                stmtOrderInfo.setTimestamp(2, date);
                stmtOrderInfo.setFloat(3, total);
                stmtOrderInfo.setNString(4, name);
                stmtOrderInfo.setNString(5, address);

                rs = stmtOrderInfo.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("orderId");

                    // Add Order Details
                    stmtOrderDetails.setInt(1, result);
                    Map<Integer, CartProductDTO> cartList = cart.getCart();
                    Set<Integer> idSey = cartList.keySet();

                    for (Integer id : idSey) {
                        stmtOrderDetails.setInt(2, id);
                        stmtOrderDetails.setInt(3, cartList.get(id).getQuantity());
                        stmtOrderDetails.setFloat(4, cartList.get(id).getPrice());
                        stmtOrderDetails.executeUpdate();

                        String update = "UPDATE tblProducts "
                                + "SET quantity = ? "
                                + "WHERE productID = ?";
                        stmtUpdate = con.prepareStatement(update);
                        TblProductsDAO productDAO = new TblProductsDAO();
                        int oldQuantity = productDAO.getProduct(id).getQuantity();

                        int newQuantity = oldQuantity - cartList.get(id).getQuantity();
                        stmtUpdate.setInt(1, newQuantity);
                        stmtUpdate.setInt(2, id);
                        stmtUpdate.executeUpdate();
                    }

                }
                con.commit(); // Commit Change to DB
            }
        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
            }
            throw new SQLException(ex);
        } finally {
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
