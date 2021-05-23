/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.productInfo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import phongnt.utils.DBHelpers;


/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class ProductInfoDAO implements Serializable {
    
    public ArrayList<ProductInfoDTO> getProductList()
        throws SQLException, NamingException {
        ArrayList<ProductInfoDTO> productList = null;
        Connection con = null;
        PreparedStatement stmt = null;
//        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT id, title, publish_year, price "
                        + "FROM productInfo ";
                stmt = con.prepareStatement(sqlStr);
                rs = stmt.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        if (productList == null) {
                            productList = new ArrayList<>();
                        }
                        ProductInfoDTO dto = new ProductInfoDTO(rs.getInt("id"), 
                                                    rs.getString("title"), 
                                                    rs.getInt("publish_year"), 
                                                    rs.getDouble("price"));
                        productList.add(dto);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
            return productList;
        }
        
    }
    
    public ProductInfoDTO getProduct(int id) 
        throws SQLException, NamingException {
        ProductInfoDTO product = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT title, publish_year, price "
                        + "FROM productInfo "
                        + "WHERE id = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    product = new ProductInfoDTO(id, rs.getNString("title"), 
                                    rs.getInt("publish_year"), rs.getDouble("price"));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
            return product;
        }
    }
    
}
