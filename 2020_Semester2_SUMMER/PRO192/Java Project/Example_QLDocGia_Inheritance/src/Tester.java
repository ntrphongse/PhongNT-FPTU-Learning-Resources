
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
        // Tạo DocGia
//        Scanner sc = new Scanner(System.in);
//        int ma;
//        String ten;
//        System.out.println("Nhap ma: ");
//        ma = sc.nextInt();
//        sc = new Scanner(System.in);
//        System.out.println("Nhap ten: ");
//        ten = sc.nextLine();
//        
//        DocGia dg = new DocGia(ma, ten);
//        dg.xuat();
//        
//        //Tạo DocGiaVIP
//        DocGiaVIP dgv = new DocGiaVIP();
//        
//        // Sửa ma dgv
//        dgv.setMa(20);
//        dgv.setTen("Phong");
//        dgv.setTienTV(20000);
//        
//        dgv.xuatDGVip();
        
        // tao 1 Doc gia
        DocGia dgv2 = new DocGiaVIP(3, "Cong", 500000);
        
        if (dgv2 instanceof DocGiaVIP) // if (dgv2 instanceof DocGia) ==> True  (Kiểm tra mối quan hệ is-a)
            ((DocGiaVIP)dgv2).xuat(); // OK
        dgv2 = new DocGiaSVIP(4, "Phung", 0.1f);
        if (dgv2 instanceof DocGiaSVIP)
            ((DocGiaVIP)dgv2).xuat();
        
        
    }
    
}
