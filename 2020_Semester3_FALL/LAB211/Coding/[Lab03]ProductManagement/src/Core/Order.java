/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Validation.MyValidation;


/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Order {
    private String productName;
    private double price;
    private int quantity;

    public Order(String productName, double price, int quantity){
        try {
            if (!MyValidation.isName(productName))
                throw new Exception("Product name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
            if (price < 0)
                throw new Exception("Product price has to be a positive number!");
            if (quantity < 0)
                throw new Exception("Product quantity has to be a integer that is equal or bigger than 0!");
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        } catch (Exception ex) {
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
