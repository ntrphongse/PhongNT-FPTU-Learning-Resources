/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.tblProducts;

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
public class TblProductsDAO implements Serializable {

    private ArrayList<TblProductsDTO> productList;

    public ArrayList<TblProductsDTO> getProductList() {
        return productList;
    }

    /**
     * Search for all the Products that are available
     *
     * @throws SQLException
     * @throws NamingException
     */
    public void getProducts(int categoryID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                if (categoryID > 0) {
                    String sqlStr = "SELECT productID, productName, quantity, price, image, categoryID "
                            + "FROM tblProducts "
                            + "WHERE quantity > 0 AND categoryID = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setInt(1, categoryID);
                } else {
                    String sqlStr = "SELECT productID, productName, quantity, price, image, categoryID "
                            + "FROM tblProducts "
                            + "WHERE quantity > 0";
                    stmt = con.prepareStatement(sqlStr);
                }
                rs = stmt.executeQuery();

                while (rs.next()) {
                    TblProductsDTO dto = new TblProductsDTO(
                            rs.getInt("productID"),
                            rs.getNString("productName"),
                            rs.getInt("quantity"),
                            rs.getFloat("price"),
                            rs.getString("image"),
                            rs.getInt("categoryID")
                    );
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

    public TblProductsDTO getProduct(int id)
            throws SQLException, NamingException {

        TblProductsDTO result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT productID, productName, quantity, price, image, categoryID "
                        + "FROM tblProducts "
                        + "WHERE productID = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    result = new TblProductsDTO(
                            rs.getInt("productID"),
                            rs.getNString("productName"),
                            rs.getInt("quantity"),
                            rs.getFloat("price"),
                            rs.getString("image"),
                            rs.getInt("categoryID")
                    );
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

    public float getPrice(int id)
            throws SQLException, NamingException {

        float price = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "SELECT price "
                        + "FROM tblProducts "
                        + "WHERE productID = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    price = rs.getFloat("price");
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
        return price;
    }
   
}
