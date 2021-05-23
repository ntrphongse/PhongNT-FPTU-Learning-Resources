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
public class AccountInfoUpdateError implements Serializable {
    private String passwordLengthErr;
    private String lastnameLengthErr;
    private String cannotUpdateErr;
    private String errorMsg;

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getLastnameLengthErr() {
        return lastnameLengthErr;
    }

    public void setLastnameLengthErr(String lastnameLengthErr) {
        this.lastnameLengthErr = lastnameLengthErr;
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
    
    
    
}
