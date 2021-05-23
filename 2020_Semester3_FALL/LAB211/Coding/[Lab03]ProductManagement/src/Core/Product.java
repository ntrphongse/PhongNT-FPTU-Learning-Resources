/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Validation.MyValidation;
import java.text.DecimalFormat;


/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String categoryID;
    private DecimalFormat df = new DecimalFormat("#");

    public Product(String id, String name, double price, int quantity, String categoryID) {
        try {
            if (!MyValidation.isID(id))
                throw new Exception("Product ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
            if (!MyValidation.isName(name))
                throw new Exception("Product name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
            if (!MyValidation.checkFloatNumMin(price, 0))
                throw new Exception("Product price has to be a positive number!");
            if (!MyValidation.checkIntNumMin(quantity, 0))
                throw new Exception("Product quantity has to be a integer that is equal or bigger than 0!");
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.categoryID = categoryID;
        } catch (Exception ex) {
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        df.setMaximumFractionDigits(0);
        return id + "," + name + "," + df.format(price) + "," + quantity + "," + categoryID;
    }
    
    
}
