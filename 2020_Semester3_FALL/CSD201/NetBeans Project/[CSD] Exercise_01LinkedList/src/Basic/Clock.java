/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Clock {
    private String id;
    private String manufacturer;
    private double price;
    private int guarantee;

    public Clock() {
        id = manufacturer = "";
        price = guarantee = 0;
    }

    public Clock(String id, String manufacturer, double price, int guarantee) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }
    
    
}
