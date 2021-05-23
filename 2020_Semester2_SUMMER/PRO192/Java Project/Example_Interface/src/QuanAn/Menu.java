/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanAn;

/**
 *
 * @author Hp
 */
public interface Menu {
    // Khai báo tên món ăn chứ KHÔNG NÓI CÁCH LÀM
    
    int dongia = 30000; // Khai báo biến phải KHỞI TẠO TRỊ
    
    void HauNuong(); // abstract method
    // Một Method DEFAULT của interface luôn luôn là >> PUBLIC <<
    public void NgheuHapXa();
    
    /**
     *
     * 
     * Ems
     * dfa
     * asd
     * erkfs
     */
    public static void trungluoc()
    {
        System.out.println("Bo trung vao noi nuoc o nhiet do binh thuong");
        System.out.println("Dun duoi lua vua");
        System.out.println("Lay dua xoay tron theo qua trung nhe nhang");
        System.out.println("Cho den khi nuoc nong, hoac 6 phut thi dung");
        System.out.println("Ngam trung them 8 phut trong noi nuoc nong");
        System.out.println("Vot trung ra bo vao chau nuoc lanh");
    }
    
}
