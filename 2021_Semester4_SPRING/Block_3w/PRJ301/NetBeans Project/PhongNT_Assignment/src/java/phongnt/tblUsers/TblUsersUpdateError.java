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
public class TblUsersUpdateError implements Serializable {
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String phoneError;
    private String adressLengthErr;
    private String cannotUpdateErr;
    private String errorMsg;

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

    public String getCannotUpdateErr() {
        return cannotUpdateErr;
    }

    public void setCannotUpdateErr(String cannotUpdateErr) {
        this.cannotUpdateErr = cannotUpdateErr;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAdressLengthErr() {
        return adressLengthErr;
    }

    public void setAdressLengthErr(String adressLengthErr) {
        this.adressLengthErr = adressLengthErr;
    }
       
}
