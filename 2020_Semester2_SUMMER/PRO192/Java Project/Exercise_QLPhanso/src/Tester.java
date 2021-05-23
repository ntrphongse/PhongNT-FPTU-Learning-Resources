
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
        PhanSo A = new PhanSo();
        System.out.println("Thong tin phan so 1:");
        A.nhap();
        
        System.out.println("\n-------------------");
        System.out.println("Thong tin phan so 2:");
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap tu: ");
            int tu = sc.nextInt();
            sc = new Scanner(System.in);
            System.out.println("Nhap mau: ");
            int mau = sc.nextInt();
            PhanSo B = new PhanSo(tu, mau);
        
        System.out.println("-------------------");
        PhanSo C = new PhanSo();
        C = A.cong(B);
        System.out.println(A.tu + "/" + A.mau + " + " + B.tu + "/" + B.mau + " = ");
        C.xuat();
        System.out.println("-------------------");
        
        C = A.tru(B);
        System.out.println(A.tu + "/" + A.mau + " - " + B.tu + "/" + B.mau + " = ");
        C.xuat();
        System.out.println("-------------------");
        
        C = A.nhan(B);
        System.out.println(A.tu + "/" + A.mau + " * " + B.tu + "/" + B.mau + " = ");
        C.xuat();
        System.out.println("-------------------");
        
        C = A.chia(B);
        System.out.println("(" + A.tu + "/" + A.mau + ") / (" + B.tu + "/" + B.mau + ") = ");
        C.xuat();
    }
    
}
