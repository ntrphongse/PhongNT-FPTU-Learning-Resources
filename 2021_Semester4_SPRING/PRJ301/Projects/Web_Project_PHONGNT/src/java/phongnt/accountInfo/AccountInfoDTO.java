/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.accountInfo;

import java.io.Serializable;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class AccountInfoDTO implements Serializable {
    private String username;
    private String password;
    private String lastname;
    private boolean admin;

    public AccountInfoDTO() {
    }

    public AccountInfoDTO(String username, String password, String lastname, boolean admin) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.admin = admin;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
