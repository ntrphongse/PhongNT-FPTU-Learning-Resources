/*
 * Tran Phong's Project
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
import phongnt.Utils.DBHelper;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class AccountInfoDAO implements Serializable {
    public boolean checkLogin(String username, String password) 
            throws NamingException, SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        if (username.trim().isEmpty() || password.trim().isEmpty())
            return false;
        
        // 1. Connect
        con = DBHelper.createConnection();
        try {
            if (con == null) {
//                result = false;
            } else {
                // 2. Create Statement
                st = con.prepareStatement("Select username "
                                        + "From accountInfo "
                                        + "Where username = ? AND password = ?");
                st.setString(1, username);
                st.setString(2, password);
                
                // 3. Execute
                rs = st.executeQuery();
                if (rs.next())
                    result = true;
                
            }
        } finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (con != null)
                con.close();
            return result;
        }
        
    } // End Login method
    
    private List<AccountInfoDTO> searchList = null;

    public List<AccountInfoDTO> getSearchList() {
        return searchList;
    }
    
    
    public void searchByFullname(String searchString)
            throws SQLException, NamingException {
        List<AccountInfoDTO> result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DBHelper.createConnection();
            if (con != null) {
                String queryStr = "SELECT username, password, lastname, isAdmin "
                        + "FROM accountInfo "
                        + "WHERE lastname LIKE ?";
                
                stmt = con.prepareStatement(queryStr);
                stmt.setString(1, "%" + searchString + "%");
                
                rs = stmt.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        AccountInfoDTO dto = new AccountInfoDTO(
                                rs.getString("username"), 
                                rs.getString("password"), 
                                rs.getNString("lastname"),
                                rs.getBoolean("isAdmin")
                        );
                        if (this.searchList == null) {
                            this.searchList = new ArrayList<>();
                        }
                        this.searchList.add(dto);
                    } // End While
                } // EndIf RS is not null
            } // EndIf Connection is not null
            
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
    } // end Method Search
    
    public boolean deleteAccount(String username)
            throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            // 1. Get Connection
            con = DBHelper.createConnection();
            if (con != null) {
                String queryStr = "DELETE "
                        + "FROM accountInfo "
                        + "WHERE username = ?";
                stmt = con.prepareStatement(queryStr);
                stmt.setString(1, username);
                
                int iCount = stmt.executeUpdate();
                if (iCount > 0) {
                    result = true;
                }
            } // EndIf Is Connected
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
}
