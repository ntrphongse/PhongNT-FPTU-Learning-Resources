/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.cart;

import java.io.Serializable;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CartObjAddToCartError implements Serializable {
    private String numberFormatErr;

    public String getNumberFormatErr() {
        return numberFormatErr;
    }

    public void setNumberFormatErr(String numberFormatErr) {
        this.numberFormatErr = numberFormatErr;
    }
    
}
