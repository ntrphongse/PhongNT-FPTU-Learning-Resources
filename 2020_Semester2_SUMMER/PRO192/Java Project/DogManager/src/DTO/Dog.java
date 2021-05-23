/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Comparator;

/**
 *
 * @author Hp
 */
public class Dog implements Comparable<Dog>{
    // Comparator
    private int id;
    private String name;

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dog() {
        id = 0;
        name = "";
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
        this.name = name;
    }    
    
    @Override
    public String toString()
    {
        return "Dog - ID: " + id + "; Name: " + name; 
    }

    @Override
    public int compareTo(Dog o) {
        if (this.name.compareTo(o.name) > 0)
            return 1;  // Đổi chỗ
        else if (this.name.compareTo(o.name) < 0)
            return -1;
        else
            return 0;
    }

    public static Comparator<Dog> basedID = new Comparator<Dog>() {
        @Override
        public int compare(Dog o1, Dog o2) {
            if (o1.getId() > o2.getId())
                return 1;
            else if (o1.getId() < o2.getId())
                return -1;
            return 0;
        }
    };
}
