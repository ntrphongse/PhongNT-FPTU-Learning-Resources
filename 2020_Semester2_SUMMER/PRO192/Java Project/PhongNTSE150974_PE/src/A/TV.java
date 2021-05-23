/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import MyLib.MyValidation;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TV extends Electric {
    int Size;
    String Brand;
    static int volte = 220;

    public TV(int Size, String Brand, String Id, String Name, int Price) {
        super(Id, Name, Price);
        this.Size = Size;
        try {
            if (!(MyValidation.checkString(Brand, "Samsung|Sony")))
                throw new Exception("Invalid Brand!");
            this.Brand = Brand;
        }
        catch (Exception e) {
            System.out.println("Invalid Brand! Please try again (only Samsung or Sony are allowed)");
        }
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        try {
            if (!(MyValidation.checkString(Brand, "Samsung|Sony")))
                throw new Exception("Invalid Brand!");
            this.Brand = Brand;
        }
        catch (Exception e) {
            System.out.println("Invalid Brand! Please try again (only Samsung or Sony are allowed)");
        }
    }
    
    @Override
    public String toString() {
        return Id + "-" + Name + "-" + Price + "-" + Size + "-" + Brand + "-" + volte;
    }
    
    public static void changeVolte(int newVolte)
    {
        try {
            if (!(newVolte == 110 || newVolte == 220 || newVolte == 240))
                throw new Exception("Invalid Volte!");
            TV.volte = newVolte;
        }
        catch (Exception e) {
            System.out.println("Invalid Volte! Please try again (only 110, 220 or 240 are allowed)");
        }
    }
}
