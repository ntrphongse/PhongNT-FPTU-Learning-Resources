/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class FoodProduct extends Product {
    String date, expiredDate;

    public FoodProduct()
    {
        super();
        date = "";
        expiredDate = "";
    }
    
    public FoodProduct(int code, String name, String make, int price, String date, String expiredDate) {
        super(code, name, make, price);
        this.date = date;
        this.expiredDate = expiredDate;
    }

    public String getDate() {
        return date;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setDate(String date) {
        if (!date.equals(""))
            this.date = date;
    }

    public void setExpiredDate(String expiredDate) {
        if (!expiredDate.equals(""))
            this.expiredDate = expiredDate;
    }
   
}
