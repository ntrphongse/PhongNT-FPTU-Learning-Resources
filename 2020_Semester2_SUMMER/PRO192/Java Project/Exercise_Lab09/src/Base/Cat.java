/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import MyLib.MyValidation;

/**
 *
 * @author Hp
 */
public class Cat extends Animal {
    String sex;
    String colorHair;

    public Cat() {
        super();
        sex = "";
        colorHair = "";
    }

    public Cat(String sex, String colorHair, int id, String name) {
        super(id, name);
        this.sex = sex;
        this.colorHair = colorHair;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        try
        {
            if (!MyValidation.checkString(sex.toLowerCase(), "male|female"))
                throw new Exception("Please enter male or female!");
            else
                this.sex = sex;
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public String getColorHair() {
        return colorHair;
    }

    public void setColorHair(String colorHair) {
        try 
        {
            if (MyValidation.checkEmptyString(colorHair))
                throw new Exception("Empty Color!");
            else
                this.colorHair = colorHair;
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return id + ";" + name + ";" + sex + ";" + colorHair;
    }
    
    
    
}
