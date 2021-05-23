/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Statue implements Comparable<Statue>{
    String ID = "";
    String author = "";
    double height = 0;
    double weight = 0;

    public Statue(String ID) {
        this.ID = ID;
    }

    public Statue(String ID, String author, double height, double weight) {
        this.ID = ID;
        this.author = author;
        this.height = height;
        this.weight = weight;
    }

    public String getID() {
        return ID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Statue o) {
        return ID.compareTo(o.ID);
    }

    @Override
    public String toString() {
        return ID + ", " + author + ", " + height + ", " + weight;
    }
    
    
}
