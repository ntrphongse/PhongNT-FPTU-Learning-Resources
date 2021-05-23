/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TestDTO implements Serializable {
    private String ID;
    private String name;
    private String description;
    private float price;
    private int cookingTime;
    private boolean delete;
    private Timestamp createDate;

    public TestDTO() {
    }

    public TestDTO(String ID, String name, String description, float price, int cookingTime, boolean isDelete, Timestamp createDate) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cookingTime = cookingTime;
        this.delete = isDelete;
        this.createDate = createDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    
}
