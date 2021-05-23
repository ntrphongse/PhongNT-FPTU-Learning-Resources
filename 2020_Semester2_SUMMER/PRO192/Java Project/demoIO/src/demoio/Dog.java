/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoio;

import java.io.Serializable;

/**
 *
 * @author Hp
 */
public class Dog implements Serializable {
    int id;
    String name;

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
