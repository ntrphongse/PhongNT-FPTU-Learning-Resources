/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class USB {
    int code;
    int capacity;
    
    static String model = "China";

    public USB() {
        code = 0;
        capacity = 0;
    }

    public USB(int code, int capacity) {
        this.code = code;
        this.capacity = capacity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if (code > 0)
            this.code = code;
    }

    public String getCapacity() {
        return capacity + "GB";
    }

    public void setCapacity(int capacity) {
        if (capacity > 0)
            this.capacity = capacity;
    }

    @Override
    public String toString() {
        return code + " - " + capacity + "GB - " + model;
    }
    
    public static void changeModel()
    {
        model = "VietNam";
    }
    
    public static String getModel()
    {
        return model;
    }
    
    
}
