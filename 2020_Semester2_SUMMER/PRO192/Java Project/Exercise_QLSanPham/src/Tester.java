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
        SanPham s = new SanPham();
        s.nhap();
        s.xuat();
        
        System.out.println("----------------------------");
        SanPham s2 = new SanPham(25, "Tran Phong", 150000, 0.15);
        s2.xuat();
    }
}
