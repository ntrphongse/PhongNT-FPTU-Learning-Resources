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
        HinhTron d1 = new HinhTron();
        System.out.println("Nhap thong tin hinh tron thu nhat!");
        d1.nhap();
        
        HinhTron d2 = new HinhTron();
        System.out.println("\nNhap thong tin hinh tron thu hai!");
        d2.nhap();
        
        // Check rela
        int iCheck = d1.check_rela(d2);
        /*
        Hàm kiểm tra mối quan hệ giữa hai hình tròn
        + Return 0: Hai hình tròn không giao nhau (tức kc > rSum)
        + Return 1: Hai hình tròn tiếp xúc ngoài (tức kc == rSum)
        + Return 2: Hai hình tròn đồng tâm (tức kc == 0)
        + Return -1: Các trường hợp còn lại
        */
        switch (iCheck)
        {
            case 0:
                System.out.println("Hai hinh tron khong giao nhau!");
                break;
            case 1:
                System.out.println("Hai hinh tron tiep xuc ngoai!");
                break;
            case 2:
                System.out.println("Hai hinh tron dong tam!!");
                break;
            case -1:
                System.out.println("Truong hop con lai!!!");
                break;
        }
        
        // ----------------------------
        System.out.println("------------------");
        System.out.println("Thong tin hinh tron thu 3");
        HinhTron d3 = new HinhTron(3.25, -2.5, 2.4);
        d3.xuat();
        
    }
}
