/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Product {
    int code;
    String name, make;
    int price;

    public Product()
    {
        code = 0;
        name = "";
        make = "";
        price = 0;
    }
    
    public Product(int code, String name, String make, int price) {
        this.code = code;
        this.name = name;
        this.make = make;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public String getMake() {
        return make.toUpperCase();
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setCode(int code) {
        if (code > 0)
            this.code = code;
    }
    
    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
    }
    
    public void setMake(String make) {
        if (!make.isEmpty())
            this.make = make;
    }
    
    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }
}
