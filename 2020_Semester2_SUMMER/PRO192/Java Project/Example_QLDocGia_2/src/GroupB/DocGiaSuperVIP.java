/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupB;

import GroupA.DocGia;

/**
 *
 * @author Hp
 */
public class DocGiaSuperVIP extends DocGia {
    String email;

    public DocGiaSuperVIP() {
        super();
        email = "";
    }

    public DocGiaSuperVIP(String email, String ma, String ten, String diachi, String dienthoai, int diemTichLuy) {
        super(ma, ten, diachi, dienthoai, diemTichLuy);
        this.email = email;
    }
    
    public DocGiaSuperVIP(String email, String diachi, String dienthoai) {
        super("", "", diachi, dienthoai, 0);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
//    public void xuatDGSVIP()
//    {
//        System.out.println("Ma: " + getMa());
//        System.out.println("Dia chi: " + diachi);
//        System.out.println("Dien thoai: " + dienthoai);
//        
//    }
    void xuat()
    {
        System.out.println("Ahihi");
    }
}
