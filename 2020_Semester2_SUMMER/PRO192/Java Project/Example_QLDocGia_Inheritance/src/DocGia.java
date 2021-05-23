
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
public class DocGia {
    int ma;
    String ten;
    
    public DocGia()
    {
        ma = 0;
        ten = "";
    }
    
    public DocGia(int ma, String ten)
    {
        this.ma = ma;
        this.ten = ten;
    }
    
    public int getMa()
    {
        return ma;
    }
    
    public String getTen()
    {
        return ten.toUpperCase();
    }
    
    public void setTen(String tenmoi)
    {
        if (!tenmoi.isEmpty())
           // or if(!tenmoi.equals(""))
            ten = tenmoi;
    }
    
    public void setMa(int mamoi)
    {
        if (mamoi > 0)
            ma = mamoi;
    }
    
    void nhap()
    {
        Scanner sc=new Scanner(System.in); // Moi lan nhap tu BAN PHIM
        
        // Go "sout" Tab
        System.out.println("Nhap ma: ");  // Xuat ra man hinh
        ma = sc.nextInt();
        // nextInt: Nhap so nguyen tu ban phim
        
        sc=new Scanner(System.in); // Tao lai cong cu nhap se xoa ki tu rac
        System.out.println("Nhap ten: ");
        ten = sc.nextLine(); // Nhap Chuoi
    }
    
    void xuat()
    {
        System.out.println("Ma: " + ma);
        System.out.println("Ten: " + ten);
    }
    
    
}
