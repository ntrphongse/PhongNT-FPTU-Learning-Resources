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
public class Animal {
    int id;
    String name;

    public Animal() {
        id = 0;
        name = "";
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try
        {
            if(MyValidation.checkEmptyString(name))
                throw new Exception("Empty Name!");
            else
                this.name = name;
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }   
}
