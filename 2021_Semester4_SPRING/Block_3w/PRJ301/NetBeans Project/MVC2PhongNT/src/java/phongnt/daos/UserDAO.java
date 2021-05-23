/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phongnt.dtos.UserDTO;
import phongnt.utils.DBUtils;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UserDAO {
    public boolean checkLogin1(String userID, String password)
        throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT userID "
                        + "FROM tblUsers "
                        + "WHERE userID = ? AND password = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, userID);
                stmt.setString(2, password);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    result = true;
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
    
    public UserDTO checkLogin(String userID, String password) 
        throws SQLException, NamingException {
        
        UserDTO user = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT fullName, roleID "
                        + "FROM tblUsers "
                        + "WHERE userID = ? AND password = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, userID);
                stmt.setString(2, password);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getNString("fullName");
                    String roleID = rs.getString("roleID");
                    
                    user = new UserDTO(userID, fullName, roleID, "");
                }
            }
        }
        finally {
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
        return user;
    }
    
    public List<UserDTO> getListUser (String search) 
        throws SQLException, NamingException {
        List<UserDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT userID, fullName, roleID "
                        + "FROM tblUsers "
                        + "WHERE fullName LIKE ? ";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + search + "%");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getNString("fullName");
                    String roleID = rs.getString("roleID");
                    list.add(new UserDTO(userID, fullName, roleID, "***"));
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
        return list;
    }
    
    public boolean delete(String userID) 
        throws SQLException, NamingException {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM tblUsers "
                        + "WHERE userID = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, userID);
                int iCheck = stmt.executeUpdate();
                if (iCheck > 0) {
                    result = true;
                }
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
    
    public boolean update(UserDTO user) 
        throws SQLException, NamingException {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblUsers "
                        + "SET fullName = ?, roleID = ? "
                        + "WHERE userID = ? ";
                stmt = con.prepareStatement(sql);
                stmt.setNString(1, user.getFullname());
                stmt.setString(2, user.getRoleID());
                stmt.setString(3, user.getUserID());
                
                result = stmt.executeUpdate() == 0 ? false : true;
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
    
    public boolean checkDuplicated(String userID) 
        throws SQLException, NamingException {
        boolean check = false;
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT userID "
                        + "FROM tblUsers "
                        + "WHERE userID = ? ";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, userID);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } 
        finally {
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
        
        return check;
    }
    
    public boolean insert(UserDTO user) 
        throws SQLException, NamingException {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tblUsers "
                        + "(userID, fullName, roleID, password) "
                        + "VALUES (?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, user.getUserID());
                stmt.setNString(2, user.getFullname());
                stmt.setString(3, user.getRoleID());
                stmt.setString(4, user.getPassword());
                
                result = stmt.executeUpdate() == 0 ? false : true;
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
