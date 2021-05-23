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
import javax.naming.NamingException;
import phongnt.Utils.DBHelper;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class AccountInfoDAO implements Serializable {

    /**
     * Check login for a specific username and password
     * @param username 
     * @param password
     * @return true if login successfully
     * @throws NamingException
     * @throws SQLException
     */
    public boolean checkLogin(String username, String password) 
        throws NamingException, SQLException {
        
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || password == null || 
                    username.trim().isEmpty() || password.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT username, lastname "
                            + "FROM accountInfo "
                            + "WHERE username = ? AND password = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        result = true;
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
        }
        return result;
    }
    
    /**
     * Get Last name based on username
     * @param username
     * @return the Last name that was found, if not, null is returned
     * @throws NamingException
     * @throws SQLException
     */
    public String getLastName(String username) 
            throws NamingException, SQLException {
        
        String lastName = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT lastname "
                            + "FROM accountInfo "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        lastName = rs.getNString("lastname");
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
        }
        return lastName;
        
    }
    
    public int isAdmin (String username) 
        throws SQLException, NamingException {
        int isAdmin = -1;
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (username == null || username.trim().isEmpty()) {
//              isAdmin = -1;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT isAdmin "
                            + "FROM accountInfo "
                            + "WHERE username = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        isAdmin =  (rs.getBoolean("isAdmin")) ? 1 : 0;
                        
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
        }
        return isAdmin;
    }
    
    private ArrayList<AccountInfoDTO> accountList;

    public ArrayList<AccountInfoDTO> getAccountList() {
        return accountList;
    }
    
    /**
     * Find all the Accounts that has the Last name contains the search value
     * @param searchValue
     * @return ArrayList of AccountInfoDTO or null if there is no matched record
     * @throws SQLException
     * @throws NamingException
     */
    public void searchByLastname (String searchValue) 
        throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (!searchValue.trim().isEmpty()) {
                searchValue = searchValue.trim();
                
                con = DBHelper.makeConnection();
                
                if (con != null) {
                    String sqlStr = "SELECT username, password, lastname, isAdmin "
                            + "FROM accountInfo "
                            + "WHERE lastname LIKE ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, "%" + searchValue + "%");
                    
                    rs = stmt.executeQuery();
                    
                    while (rs.next()) {
                        AccountInfoDTO dto = new AccountInfoDTO(
                                rs.getString("username"), 
                                rs.getString("password"), 
                                rs.getNString("lastname"), 
                                rs.getBoolean("isAdmin")
                        );
                        
                        if (this.accountList == null) {
                            this.accountList = new ArrayList<>();
                        }
                        
                        this.accountList.add(dto);
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
        }
    }
    
    /**
     * Delete an account with a specific username
     * @param username
     * @return true if delete successfully, otherwise, return false
     * @throws SQLException
     * @throws NamingException
     */
    public boolean deleteAccount (String username) 
        throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sqlStr = "DELETE "
                        + "FROM accountInfo "
                        + "WHERE username = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, username);

                int iCount = stmt.executeUpdate();

                if (iCount > 0) {
                    result = true;
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
        
        return result;
    }
    
    /**
     * Update an Account information
     * @param username
     * @param password
     * @param lastname
     * @param admin
     * @return true if update successfully, otherwise return false
     * @throws SQLException
     * @throws NamingException
     */
    public boolean updateAccount (String username, 
            String password, String lastname, boolean admin) 
        throws SQLException, NamingException {
        
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "UPDATE accountInfo "
                        + "SET password = ?, lastname = ?, isAdmin = ? "
                        + "WHERE username = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, password);
                stmt.setNString(2, lastname);
                stmt.setBoolean(3, admin);
                stmt.setString(4, username);
                
                int iCount = stmt.executeUpdate();
                if (iCount > 0) {
                    // Update successfully
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
    
    /**
     * Create a new account
     * @param username
     * @param password
     * @param lastname
     * @param isAdmin
     * @return true if create successfully, otherwise, return false
     * @throws SQLException
     * @throws NamingException
     */
    public boolean createAccount(String username, String password, 
            String lastname, boolean isAdmin) 
        throws SQLException, NamingException {
        
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "INSERT INTO accountInfo "
                        + "(username, password, lastname, isAdmin) "
                        + "VALUES (?, ?, ?, ?)";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, lastname);
                stmt.setBoolean(4, isAdmin);
                
                int iCount = stmt.executeUpdate();
                if (iCount > 0) {
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
}
