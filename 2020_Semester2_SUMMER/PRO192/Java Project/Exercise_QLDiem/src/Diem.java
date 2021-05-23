
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Diem {
    
    // fields
    double x;
    double y;
    
    // methods
        // constructors
    public Diem()
    {
        x = 0;
        y = 0;
    }
    
    public Diem(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
        // getters
    public double getx()
    {
        return x;
    }
    
    public double gety()
    {
        return y;
    }
    
        // setters
    public void setx(double x)
    {
        this.x = x;
    }
    
    public void sety(double y)
    {
        this.y = y;
    }
    
        // Ham xu ly khac
        
        // Nhap diem
    void nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap x = ");
        x = sc.nextFloat();
        sc=new Scanner(System.in);
        System.out.println("Nhap y = ");
        y = sc.nextFloat();

    }
        
        // Xuat diem
    void xuat()
    {
        System.out.println("x = " + x);
        System.out.println("y = "+ y);
    }
    
        // Tinh khoang cach giua hai diem
    double KhoangCach(double x2, double y2)
    {
        return Math.sqrt((x2 - x)*(x2 - x) + (y2 - y)*(y2 - y));
    }
   
        // Ham tinh khoang cach cach khac
    double KhoangCach(Diem d)
    {
        return Math.sqrt((d.x - x)*(d.x - x) + (d.y - y)*(d.y - y));
    }
    
    // Hai ham cung tinh nang co the co ten giong nhau, chi can khac tham so la duoc!!
    
    
}
