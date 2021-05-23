/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.product;

import java.io.Serializable;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ProductErrorDTO implements Serializable {
    private String idError;
    private String nameError;
    private String descriptionError;
    private String priceError;
    private String cookingTimeError;
    private String statusError;
    private String createDateError;
    private String error;

    public ProductErrorDTO() {
    }

    public ProductErrorDTO(String idError, String nameError, String descriptionError, String priceError, String cookingTimeError, String statusError, String createDateError, String error) {
        this.idError = idError;
        this.nameError = nameError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
        this.cookingTimeError = cookingTimeError;
        this.statusError = statusError;
        this.createDateError = createDateError;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

   

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getCookingTimeError() {
        return cookingTimeError;
    }

    public void setCookingTimeError(String cookingTimeError) {
        this.cookingTimeError = cookingTimeError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getCreateDateError() {
        return createDateError;
    }

    public void setCreateDateError(String createDateError) {
        this.createDateError = createDateError;
    }
    
    
}
