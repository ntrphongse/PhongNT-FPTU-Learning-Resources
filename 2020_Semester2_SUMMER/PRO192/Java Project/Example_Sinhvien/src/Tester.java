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
    // Go "pub" Ctrl + Space Enter
    public static void main(String[] args) {
        // Luu ma ten <-- Co vung nho ===> KHAI BAO VUNG NHO de chua ma, ten
        SinhVien a = new SinhVien();  // Kieu du lieu SinhVien ------- a la con tro, co KDL la ten lop SinhVien
        // Default a = NULL; a phai co gia tri
        // Khoi tao vung nho du de chua TAT CA cac fields cua CLASS SinhVien tu constructor SinhVien()
        
        a.nhap();
        a.xuat();
        
        // Nhu cầu SỬA MÃ sau khi nhập
        int mamoi = 20;
        a.setMa(mamoi);
        a.xuat();
        
        SinhVien b = new SinhVien();
        b.nhap();
        // b.xuat();
        
        // In ra TÊN của SV thứ 2
        System.out.println("" + b.getTen());
        
        SinhVien c = new SinhVien(5, "Phong");
        c.xuat();
        
        SinhVien d = new SinhVien(c);  // Copy du lieu tu doi tuong khac tuong dong
        d.xuat();
    }
}
