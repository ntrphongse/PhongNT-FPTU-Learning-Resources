/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Shape {
    String color;
    boolean filled;
    
    public Shape()
    {
        color = "red";
        filled = true;
    }
    
    public Shape(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor()
    {
        return color.toUpperCase();
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public boolean isFilled()
    {
        return filled;
    }
    
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
}
