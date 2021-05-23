/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.accountInfo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phongnt.utils.DBHelpers;

/**
 *
 * @author Hp
 */
public class AccountInfoDAO implements Serializable {
    public boolean checkLogin(String username, String password) 
        throws SQLException, /* ClassNotFoundException */ NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            // 1. Connect DB
            con = DBHelpers.makeConnection();
            if (con != null) {
                // 2. Create SQL String
                String sql = "SELECT username "
                        + "FROM accountInfo "
                        + "WHERE username = ? AND password = ?";
                // 3. Create Statement and Assign Parameter if any
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                // 4. Execute Query
                rs = stm.executeQuery();
                
                // 5. Process rs
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            
        }
        
        return false;
    }
    
    private List<AccountInfoDTO> accountList;

    public List<AccountInfoDTO> getAccountList() {
        return accountList;
    }
    
    public void searchLastname(String searchValue) 
            throws SQLException, /* ClassNotFoundException */ NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // 1. Connect DB
            con = DBHelpers.makeConnection();
            if (con != null) {
                // 2. Create SQL String
                String sql = "Select username, password, lastname, isAdmin "
                        + "From accountInfo "
                        + "Where lastname Like ?";
                
                // 3. Create Statement & Assign Paramaters' values
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + searchValue + "%");
                
                // 4. Execute Query
                rs = stmt.executeQuery();
                
                // 5. Process result
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullname = rs.getNString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    
                    AccountInfoDTO dto = new AccountInfoDTO(
                            username, password, fullname, role);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    }
                    this.accountList.add(dto);
                }
                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con!= null) {
                con.close();
            }
        }
    }
    
    public boolean deleteAccount(String username)
            throws SQLException, /* ClassNotFoundException */ NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            // 1. Connect DB
            con = DBHelpers.makeConnection();
            if (con != null) {
                // 2. Create SQL String
                String sql = "Delete From AccountInfo "
                        + "Where username = ?" ;
                // 3. Create Statement & Assign Paramaters' values
                stmt = con.prepareStatement(sql);
                stmt.setString(1, username);
                // 4. Execute Query
                int row = stmt.executeUpdate();
                // 5. Process rs
                if (row > 0) {
                    return true;
                }
            } // EndIf con is connected
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con!= null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateAccount(String username, String newPassword, boolean newRole)
            throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        int iCount = 0;
        
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String queryStr = "UPDATE accountInfo "
                        + "SET password = ?, isAdmin = ? "
                        + "WHERE username = ?";
                stmt = con.prepareStatement(queryStr);
                stmt.setString(1, newPassword);
                stmt.setBoolean(2, newRole);
                stmt.setString(3, username);
                iCount = stmt.executeUpdate();
                
                if (iCount > 0) {
                    result = true;
                }
            } // EndIf Connected
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
            return result;
        }
    }
    
    public boolean createNewAccount(String username, String password, 
                                    String fullName, boolean role) 
        throws NamingException, SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        int iCount = 0;
        
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                
                String queryStr = "INSERT INTO "
                        + "accountInfo(username, password, lastname, isAdmin) "
                        + "VALUES(?, ?, ?, ?)";
                
                stmt = con.prepareStatement(queryStr);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setNString(3, fullName);
                stmt.setBoolean(4, role);
                
                iCount = stmt.executeUpdate();
                
                if (iCount > 0) {
                    result = true;
                }
            } // EndIf Connected
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
