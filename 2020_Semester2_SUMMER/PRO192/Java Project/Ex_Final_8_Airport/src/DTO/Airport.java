/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Airport {
    String id;
    String name;
    String address;
    long area;

    public Airport() {
    }

    public Airport(String id, String name, String address, long area) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.area = area;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
    
    
}
