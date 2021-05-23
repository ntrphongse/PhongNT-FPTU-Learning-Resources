/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ElectricProduct extends Product {
    String guaranty;
    int voltage;
    float power;

    public ElectricProduct()
    {
        super();
        guaranty = "";
        voltage = 0;
        power = 0;
    }
    
    public ElectricProduct(int code, String name, String make, int price, String guaranty, int voltage, float power) {
        super(code, name, make, price);
        this.guaranty = guaranty;
        this.voltage = voltage;
        this.power = power;
    }

    public String getGuaranty() {
        return guaranty.toUpperCase();
    }

    public int getVoltage() {
        return voltage;
    }

    public float getPower() {
        return power;
    }

    public void setGuaranty(String guaranty) {
        if (!guaranty.isEmpty())
            this.guaranty = guaranty;
    }

    public void setVoltage(int voltage) {
        if (voltage > 0)
            this.voltage = voltage;
    }

    public void setPower(float power) {
        if (power > 0)
            this.power = power;
    }
    
}
