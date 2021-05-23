/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.tblUsers;

import java.io.Serializable;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TblUsersCreateError implements Serializable {
    private String userIDLengthErr;
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String phoneErr;
    private String addressLengthErr;
    private String confirmNotMatchErr;
    private String userIDExistedErr;
    private String errorMsg;

    public String getUserIDLengthErr() {
        return userIDLengthErr;
    }

    public void setUserIDLengthErr(String userIDLengthErr) {
        this.userIDLengthErr = userIDLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    public String getConfirmNotMatchErr() {
        return confirmNotMatchErr;
    }

    public void setConfirmNotMatchErr(String confirmNotMatchErr) {
        this.confirmNotMatchErr = confirmNotMatchErr;
    }

    public String getUserIDExistedErr() {
        return userIDExistedErr;
    }

    public void setUserIDExistedErr(String userIDExistedErr) {
        this.userIDExistedErr = userIDExistedErr;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public String getAddressLengthErr() {
        return addressLengthErr;
    }

    public void setAddressLengthErr(String addressLengthErr) {
        this.addressLengthErr = addressLengthErr;
    }
    
    
}
