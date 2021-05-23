/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupC;

import GroupA.DocGia;
import GroupA.DocGiaVIP;
import GroupB.DocGiaSuperVIP;

/**
 *
 * @author Hp
 */
public class Tester {
    public static void main(String[] args) {
        // Tao mot DocGia
        DocGia dg = new DocGia("123", "Thi No", "Lo E FPT", "123456", 5);
        System.out.println(dg.toString());
//        System.out.println("Ma: " + dg.getMa());
//        System.out.println("Ten: " + dg.getTen());
//        
//        // Tao DocGiaVIP
//        DocGia dgv = new DocGiaVIP(1000, "222", "Chi Pheo", "Lo E FPT", "1234567");
//        ((DocGiaVIP)dgv).xuat();
//        
//        // Tao DocGiaSuperVIP
//        DocGia dgsv = new DocGiaSuperVIP("abc@fpt.edu.vn", "Lo F FPT", "654321");
//        ((DocGiaSuperVIP)dgsv).xuatDGSVIP();
    }
}
