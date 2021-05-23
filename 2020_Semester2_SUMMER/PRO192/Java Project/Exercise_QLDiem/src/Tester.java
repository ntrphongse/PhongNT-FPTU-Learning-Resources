
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
public class Tester {
    public static void main(String[] args) {
        Diem D1 = new Diem();
        D1.nhap();
        D1.xuat();
        Diem D2 = new Diem();
        D2.nhap();
        D2.xuat();
        
        // Tinh khoang cach
        System.out.println("Khoang cach giua hai diem: " + D1.KhoangCach(D2.x, D2.y));
        System.out.println("Khoang cach giua hai diem: " + D1.KhoangCach(D2));
        
        System.out.println("---------------------------");
        System.out.println("Nhap thong tin diem thu 3");
            Scanner sc = new Scanner(System.in);
            System.out.println("x = ");
            double x = sc.nextDouble();
            sc = new Scanner(System.in);
            System.out.println("y = ");
            double y = sc.nextDouble();
        Diem D3 = new Diem(x, y);
        System.out.println("------------");
        D3.xuat();
        
    }
}
