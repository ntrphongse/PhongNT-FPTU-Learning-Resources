/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Hp
 */
public class Cun {
    private String id;
    private String name;
    private double PE;
    private double FE;

    public Cun(String id, String name, double PE, double FE) {
        this.id = id;
        this.name = name;
        this.PE = PE;
        this.FE = FE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPE() {
        return PE;
    }

    public void setPE(double PE) {
        this.PE = PE;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + PE + "," + FE;
    }
    
    
}
