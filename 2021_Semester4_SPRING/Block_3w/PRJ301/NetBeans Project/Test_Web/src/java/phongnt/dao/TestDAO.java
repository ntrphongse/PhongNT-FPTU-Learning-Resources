/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import phongnt.dto.TestDTO;
import phongnt.utils.DBUtils;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TestDAO implements Serializable {
    public boolean insert(TestDTO test) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            String sql = "INSERT INTO tblFoods "
                    + "(ID, Name, Description, Price, CookingTime, IsDelete, CreateDate) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, test.getID());
            stmt.setString(2, test.getName());
            stmt.setString(3, test.getDescription());
            stmt.setFloat(4, test.getPrice());
            stmt.setInt(5, test.getCookingTime());
            stmt.setBoolean(6, test.isDelete());
            stmt.setTimestamp(7, test.getCreateDate());
            int check = stmt.executeUpdate();
            
            result = check > 0;
            
        } finally {
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
