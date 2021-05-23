/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.tblUsers;

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
public class TblUsersDAO implements Serializable {

    /**
     * Check login for a specific userID and password
     * @param userID 
     * @param password
     * @return true if login successfully
     * @throws NamingException
     * @throws SQLException
     */
    public boolean checkLogin(String userID, String password) 
        throws NamingException, SQLException {
        
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (userID == null || password == null || 
                    userID.trim().isEmpty() || password.trim().isEmpty()) {
//              result = false;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT userID "
                            + "FROM tblUsers "
                            + "WHERE userID = ? AND password = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, userID);
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
     * Get Full name based on userID
     * @param userID
     * @return the Full name that was found, if not, null is returned
     * @throws NamingException
     * @throws SQLException
     */
    public String getFullName(String userID) 
            throws NamingException, SQLException {
        
        String fullName = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (userID == null || userID.trim().isEmpty()) {
//              fullName = null;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT fullName "
                            + "FROM tblUsers "
                            + "WHERE userID = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, userID);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        fullName = rs.getNString("fullName");
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
        return fullName;
        
    }
    
    public int isAdmin (String userID) 
        throws SQLException, NamingException {
        int isAdmin = -1;
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (userID == null || userID.trim().isEmpty()) {
//              isAdmin = -1;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT roleID "
                            + "FROM tblUsers "
                            + "WHERE userID = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, userID);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        isAdmin =  (rs.getString("roleID").equals("AD")) ? 1 : 0;
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
    
    private ArrayList<TblUsersDTO> accountList;

    public ArrayList<TblUsersDTO> getAccountList() {
        return accountList;
    }
    
    /**
     * Find all the Accounts that has the Full name contains the search value
     * @param searchValue
     * @return ArrayList of TblUsersDTO or null if there is no matched record
     * @throws SQLException
     * @throws NamingException
     */
    public void searchByFullName (String searchValue) 
        throws SQLException, NamingException {
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
//            if (!searchValue.trim().isEmpty()) {
//                searchValue = searchValue.trim();
                
                con = DBHelper.makeConnection();
                
                if (con != null) {
                    String sqlStr = "SELECT userID, password, fullName, roleID, phone, address "
                            + "FROM tblUsers "
                            + "WHERE fullName LIKE ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, "%" + searchValue + "%");
                    
                    rs = stmt.executeQuery();
                    
                    while (rs.next()) {
                        TblUsersDTO dto = new TblUsersDTO(
                                rs.getString("userID"), 
                                rs.getString("password"), 
                                rs.getNString("fullName"), 
                                (rs.getString("roleID").equals("AD")),
                                rs.getString("phone"),
                                rs.getNString("address")
                        );
                        
                        if (this.accountList == null) {
                            this.accountList = new ArrayList<>();
                        }
                        
                        this.accountList.add(dto);
                    }
                }
//            }
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
     * Delete an account with a specific userID
     * @param userID
     * @return true if delete successfully, otherwise, return false
     * @throws SQLException
     * @throws NamingException
     */
    public boolean deleteAccount (String userID) 
        throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();

            if (con != null) {
                String sqlStr = "DELETE "
                        + "FROM tblUsers "
                        + "WHERE userID = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, userID);

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
     * @param userID
     * @param password
     * @param fullName
     * @param phone
     * @param address
     * @param admin
     * @return true if update successfully, otherwise return false
     * @throws SQLException
     * @throws NamingException
     */
    public boolean updateAccount (String userID, 
            String password, String fullName, String phone, String address, boolean admin) 
        throws SQLException, NamingException {
        
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "UPDATE tblUsers "
                        + "SET password = ?, fullName = ?, phone = ?, address = ?, roleID = ? "
                        + "WHERE userID = ?";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, password);
                stmt.setNString(2, fullName);
                stmt.setString(3, phone);
                stmt.setNString(4, address);
                stmt.setString(5, (admin) ? "AD" : "US");
                stmt.setString(6, userID);
                
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
     * @param userID
     * @param password
     * @param fullName
     * @param phone
     * @param address
     * @param isAdmin
     * @return true if create successfully, otherwise, return false
     * @throws SQLException
     * @throws NamingException
     */
    public boolean createAccount(String userID, String password, 
            String fullName, String phone, String address, boolean isAdmin) 
        throws SQLException, NamingException {
        
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sqlStr = "INSERT INTO tblUsers "
                        + "(userID, password, fullName, phone, address, roleID) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sqlStr);
                stmt.setString(1, userID);
                stmt.setString(2, password);
                stmt.setNString(3, fullName);
                stmt.setString(4, phone);
                stmt.setNString(5, address);
                stmt.setString(6, (isAdmin) ? "AD" : "US");
                
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
    
    public String getAddress(String userID) throws NamingException, SQLException {
        String address = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (userID == null || userID.trim().isEmpty()) {
//              password = null;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT address "
                            + "FROM tblUsers "
                            + "WHERE userID = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, userID);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        address = rs.getNString("address");
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
        return address;
    }
    
    public TblUsersDTO getUserInfo(String userID) throws NamingException, SQLException {
        TblUsersDTO user = null;
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (userID == null || userID.trim().isEmpty()) {
//              fullName = null;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT userID, password, fullName, roleID, phone, address "
                            + "FROM tblUsers "
                            + "WHERE userID = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, userID);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        user = new TblUsersDTO(
                                userID, 
                                rs.getString("password"), 
                                rs.getNString("fullName"), 
                                rs.getString("roleID").equals("AD"), 
                                rs.getString("phone"), 
                                rs.getNString("address")
                        );
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
        return user;
    }
    
    public String getPassword(String userID) throws NamingException, SQLException {
        String password = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (userID == null || userID.trim().isEmpty()) {
//              password = null;
            } else {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sqlStr = "SELECT password "
                            + "FROM tblUsers "
                            + "WHERE userID = ?";
                    stmt = con.prepareStatement(sqlStr);
                    stmt.setString(1, userID);
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        password = rs.getNString("password");
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
        return password;
    }
}
