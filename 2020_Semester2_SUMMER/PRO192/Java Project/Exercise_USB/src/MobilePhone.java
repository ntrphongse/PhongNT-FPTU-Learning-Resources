/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class MobilePhone {
    int price;
    USB port;

    public MobilePhone() {
        price = 0;
        port = new USB();
    }

    public MobilePhone(int price, int code, int capacity) {
        this.price = price;
        this.port = new USB(code, capacity);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public String getPort() {
        return port.toString();
    }

    public void setPort(int code, int capacity) {
        this.port.setCode(code);
        this.port.setCapacity(capacity);
    }

    @Override
    public String toString() {
        return port.toString() + " - " + price;
    }
    
    
}
