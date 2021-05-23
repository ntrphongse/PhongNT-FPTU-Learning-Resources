
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
public class HinhTron {
    // fields
    double x;
    double y;
    double r;
    // methods
        // constructors
    public HinhTron()
    {
        x = 0;
        y = 0;
        r = 0;
    }
    
    public HinhTron(double x, double y, double r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
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
    
    public void setr(double r)
    {
        if (r > 0)
            this.r = r;
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
    
    public double getr()
    {
        return r;
    }
        // Ham xu ly khac
    // Nhap
    void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Nhap toa do cua tam I.");
        System.out.println("\tNhap x = ");
        x = sc.nextDouble();
        sc = new Scanner(System.in);
        System.out.println("\tNhap y = ");
        y = sc.nextDouble();
        sc = new Scanner(System.in);
        do 
        {
            System.out.println("Nhap ban kinh cua hinh tron (r > 0).");
            System.out.println("\tr = ");
            r = sc.nextDouble();
            sc = new Scanner(System.in);
        } while (r <= 0);
    }
    // Xuat
    void xuat()
    {
        System.out.println("--------------------");
        System.out.println("Thong tin cua hinh tron");
        System.out.println("\tToa do tam I: I(" + x + "; " + y + ")");
        System.out.println("\tBan kinh r = " + r);
    }
    // Kiem tra moi quan he
    /*
        Hàm kiểm tra mối quan hệ giữa hai hình tròn
        + Return 0: Hai hình tròn không giao nhau (tức kc > rSum)
        + Return 1: Hai hình tròn tiếp xúc ngoài (tức kc == rSum)
        + Return 2: Hai hình tròn đồng tâm (tức kc == 0)
        + Return -1: Các trường hợp còn lại
    */
    int check_rela(HinhTron B)
    {
        // Tinh khoang cach giua 2 tam
        double kc = Math.sqrt((x - B.x)*(x - B.x) + (y - B.y)*(y - B.y));
        
        // Tinh tong hai ban kinh
        double rSum = r + B.r;
        
        // So sanh
        if (kc > rSum)
            return 0;
        else if (kc == rSum)
            return 1;
        else if (kc == 0)
            return 2;
        else
            return -1;
    }
}
