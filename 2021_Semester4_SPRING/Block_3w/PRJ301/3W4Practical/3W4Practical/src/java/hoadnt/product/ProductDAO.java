/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.product;

import hoadnt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hd
 */
public class ProductDAO implements Serializable {
    public boolean insert(ProductDTO product) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tblFoods "
                        + "(id, name, description, price, cookingTime, status, createDate) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, product.getId());
                stmt.setString(2, product.getName());
                stmt.setString(3, product.getDescription());
                stmt.setFloat(4, product.getPrice());
                stmt.setInt(5, product.getCookingTime());
                stmt.setBoolean(6, product.isStatus());
                stmt.setTimestamp(7, product.getCreateDate());
                
                int iCheck = stmt.executeUpdate();
                result = iCheck > 0;
            }
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return result;
    }
    
    public List<ProductDTO> search(int from, int to) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ProductDTO> productList = new ArrayList<>();
        
        try {
            con = DBUtils.getConnection();
            String sql = "SELECT id, name, description, price, cookingTime, status, createDate "
                    + "FROM tblFoods "
                    + "WHERE cookingTime >= ? AND cookingTime <= ? AND status = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, from);
            stmt.setInt(2, to);
            stmt.setBoolean(3, true);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                ProductDTO product = new ProductDTO(
                        rs.getString("id"), 
                        rs.getString("name"), 
                        rs.getString("description"), 
                        rs.getFloat("price"), 
                        rs.getInt("cookingTime"), 
                        rs.getBoolean("status"), 
                        rs.getTimestamp("createDate")
                );
                productList.add(product);
            }
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return productList;
    }
    
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblFoods "
                        + "SET status = ? "
                        + "WHERE id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setBoolean(1, false);
                stmt.setString(2, id);
                int iCheck = stmt.executeUpdate();
                result = iCheck > 0;
            }
        }
        finally {
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
