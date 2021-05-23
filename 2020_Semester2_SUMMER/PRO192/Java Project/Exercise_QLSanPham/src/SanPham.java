
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
public class SanPham {
    
    // fields
    int ma;
    String ten;
    double gia;
    double giamgia;
    
    // methods
        // constructors
    public SanPham()
    {
        ma = 0;
        ten = "";
        gia = 0;
        giamgia = 0;
    }
    
    public SanPham(int ma, String ten, double gia, double giamgia)
    {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.giamgia = giamgia;
    }
    
    // setters
    public void setMa(int ma)
    {
        if (ma > 0)
            this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(double gia) {
        if (gia > 0)
            this.gia = gia;
    }

    public void setGiamgia(double giamgia) {
        if (giamgia > 0 && giamgia < 1)
            this.giamgia = giamgia;
    }
    
    // getters
    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten.toUpperCase();
    }

    public double getGia() {
        return gia;
    }

    
    public double getGiamgia() {    
        return giamgia;
    }

    // Ham xu ly khac
    // Nhap
    void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham: ");
        ma = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Nhap ten san pham: ");
        ten = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Nhap gia cua san pham: ");
        gia = sc.nextDouble();
        sc = new Scanner(System.in);
        System.out.println("Giam gia: ");
        giamgia = sc.nextDouble();
    }
    
    void xuat()
    {
        System.out.println("Ma san pham: " + ma);
        System.out.println("Ten san pham: " + ten);
        System.out.println("Gia goc san pham: " + gia);
        System.out.println("Giam gia: " + giamgia);
        System.out.println("Gia sau khi giam: " + iGiamGia());  // Goi ham trong cung class
    }
    
    double iGiamGia()
    {
        return (gia - gia*giamgia);
    }
    
}
