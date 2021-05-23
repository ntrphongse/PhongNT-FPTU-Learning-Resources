/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.order;

import java.io.Serializable;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderError implements Serializable {
    private String noNameErr;
    private String noAddressErr;
    private String errorMsg;

    public String getNoNameErr() {
        return noNameErr;
    }

    public void setNoNameErr(String noNameErr) {
        this.noNameErr = noNameErr;
    }

    public String getNoAddressErr() {
        return noAddressErr;
    }

    public void setNoAddressErr(String noAddressErr) {
        this.noAddressErr = noAddressErr;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}
