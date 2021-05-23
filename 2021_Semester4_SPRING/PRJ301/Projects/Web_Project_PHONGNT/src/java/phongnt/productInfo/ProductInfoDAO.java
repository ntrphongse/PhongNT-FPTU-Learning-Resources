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
import phongnt.Utils.DBHelper;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ProductInfoDAO implements Serializable {
    private ArrayList<ProductInfoDTO> productList;

    public ArrayList<ProductInfoDTO> getProductList() {
        return productList;
    }
    
    /**
     * Search for all the Products that are available
     * @throws SQLException
     * @throws NamingException
     */
    public void getProducts() 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT id, title, publish_year, price "
                        + "FROM productInfo";
                stmt = con.prepareStatement(sqlStr);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    ProductInfoDTO dto = new ProductInfoDTO(
                                            rs.getInt("id"),  
                                            rs.getNString("title"), 
                                            rs.getInt("publish_year"), 
                                            rs.getDouble("price"));
                    if (this.productList == null) {
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
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
        }
    }
    
    public ProductInfoDTO getProduct(int id) 
            throws SQLException, NamingException {
        
        ProductInfoDTO result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT id, title, publish_year, price "
                        + "FROM productInfo "
                        + "WHERE id = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    result = new ProductInfoDTO(
                                    rs.getInt("id"),  
                                    rs.getNString("title"), 
                                    rs.getInt("publish_year"), 
                                    rs.getDouble("price"));
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
        }
        return result;
    }
}
