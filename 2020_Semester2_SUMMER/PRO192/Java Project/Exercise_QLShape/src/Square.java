/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Square extends Rectangle {
    public Square()
    {
        super();
    }
    
    public Square(double side)
    {
        super(side, side);
    }
    
    public Square(double side, String color, boolean filled)
    {
        super(side, side, color, filled);
    }
    
    public double getSide()
    {
        return length;
    }
    
    public void setSide(double side)
    {
        if (side > 0)
            this.length = this.width = side;
    }
    
    public void setWidth(double side)
    {
        if (side > 0)
            this.length = this.width = side;
    }
    
    public void setLength(double side)
    {
        if (side > 0)
            this.length = this.width = side;
    }
}
