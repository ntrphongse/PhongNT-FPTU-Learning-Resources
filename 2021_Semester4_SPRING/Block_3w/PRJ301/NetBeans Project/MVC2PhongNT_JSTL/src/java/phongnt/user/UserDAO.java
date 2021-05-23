/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phongnt.utils.DBUtils;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UserDAO implements Serializable {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
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
    
    public UserDTO login(String userID, String password) 
        throws SQLException, ClassNotFoundException {
        UserDTO user = null;
        
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
                    user = new UserDTO(
                            userID, 
                            "", 
                            rs.getNString("fullName"), 
                            rs.getString("roleID")
                    );
                }
            }
        } 
        finally {
            closeConnection();
        }
        
        return user;
    }
    
    public List<UserDTO> getListUser(String search) 
        throws SQLException, ClassNotFoundException {
        
        List<UserDTO> listUser = new ArrayList<>();
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT userID, fullName, roleID "
                        + "FROM tblUsers "
                        + "WHERE fullName LIKE ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + search + "%");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    listUser.add(new UserDTO(
                            rs.getString("userID"), 
                            "***", 
                            rs.getNString("fullName"), 
                            rs.getString("roleID")
                    ));
                }
            }
        } 
        finally {
            closeConnection();
        }
        
        return listUser;
    }
    
    public boolean insert(UserDTO user) 
        throws SQLException, ClassNotFoundException {
        
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tblUsers "
                        + "(userID, password, fullName, roleID) "
                        + "VALUES (?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, user.getUserID());
                stmt.setString(2, user.getPassword());
                stmt.setNString(3, user.getFullName());
                stmt.setString(4, user.getRoleID());
                
                result = stmt.executeUpdate() == 0 ? false : true;
            }
        } 
        finally {
            closeConnection();
        }
        
        return result;
    }
    
    public boolean update(UserDTO user) 
        throws SQLException, ClassNotFoundException {
        
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblUsers "
                        + "SET fullName = ?, roleID = ?, password = ? "
                        + "WHERE userID = ?";
                stmt = con.prepareStatement(sql);
                stmt.setNString(1, user.getFullName());
                stmt.setString(2, user.getRoleID());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getUserID());
                result = stmt.executeUpdate() == 0 ? false : true;
            }
        } 
        finally {
            closeConnection();
        }
        
        return result;
    }
    
    public boolean delete(UserDTO user) 
        throws SQLException, ClassNotFoundException {
        
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM tblUsers "
                        + "WHERE userID = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, user.getUserID());
                
                result = stmt.executeUpdate() == 0 ? false : true;
            }
        } 
        finally {
            closeConnection();
        }
        
        return result;
    }
    
    public boolean checkPassword(String userID, String password) 
        throws SQLException, ClassNotFoundException {
        boolean check = false;
        
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
                    check = true;
                }
            }
        } 
        finally {
            closeConnection();
        }
        
        return check;
    }
}
