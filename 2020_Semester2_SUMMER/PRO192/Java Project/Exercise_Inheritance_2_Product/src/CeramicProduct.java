/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class CeramicProduct extends Product {
    String type;

    public CeramicProduct()
    {
        super();
        type = "";
    }
    
    public CeramicProduct(int code, String name, String make, int price, String type) {
        super(code, name, make, price);
        this.type = type;
    }

    public String getType() {
        return type.toUpperCase();
    }

    public void setType(String type) {
        if (!type.equals(""))        
            this.type = type;
        
    }
}
