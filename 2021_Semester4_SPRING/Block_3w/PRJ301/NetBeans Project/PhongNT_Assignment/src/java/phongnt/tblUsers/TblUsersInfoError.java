/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.tblUsers;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TblUsersInfoError {
    private String userIDLengthErr;
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String phoneErr;
    private String addressLengthErr;
    private String confirmNotMatchErr;
    private String oldPasswordErr;
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

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

    public String getConfirmNotMatchErr() {
        return confirmNotMatchErr;
    }

    public void setConfirmNotMatchErr(String confirmNotMatchErr) {
        this.confirmNotMatchErr = confirmNotMatchErr;
    }

    public String getOldPasswordErr() {
        return oldPasswordErr;
    }

    public void setOldPasswordErr(String oldPasswordErr) {
        this.oldPasswordErr = oldPasswordErr;
    }
    
    
    
}
