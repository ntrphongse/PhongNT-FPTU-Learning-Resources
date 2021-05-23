/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */

public class Circle extends Shape {
    double radius;
    
    public Circle()
    {
        super();
        radius = 1.0;
    }
    
    public Circle(double radius)
    {
        super();
        this.radius = radius;
    }
    
    public Circle(double radius, String color, boolean filled)
    {
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius()
    {
        return radius;
    }
    
    public void setRadius(double radius)
    {
        if (radius > 0)
            this.radius = radius;
    }
    
    public double getArea()
    {
        return (Math.PI)*radius*radius;
    }
    
    public double getPerimeter()
    {
        return (Math.PI)*2*radius;
    }
}
