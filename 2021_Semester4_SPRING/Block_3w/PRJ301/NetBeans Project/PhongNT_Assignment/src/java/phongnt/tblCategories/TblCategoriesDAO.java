/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.tblCategories;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import phongnt.Utils.DBHelper;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TblCategoriesDAO implements Serializable {
    public String getCategoryName(int categoryID) throws SQLException, NamingException {
        String categoryName = null;
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT categoryName "
                        + "FROM tblCategories "
                        + "WHERE categoryID = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, categoryID);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    categoryName = rs.getNString("categoryName");
                }
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return categoryName;
    }
    
    private Map<Integer, String> categoriesList;

    public Map<Integer, String> getCategoriesList() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT categoryID, categoryName "
                        + "FROM tblCategories ";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    if (this.categoriesList == null) {
                        this.categoriesList = new HashMap<>();
                    }
                    this.categoriesList.put(rs.getInt("categoryID"), rs.getNString("categoryName"));
                }
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return this.categoriesList;
    }

}
