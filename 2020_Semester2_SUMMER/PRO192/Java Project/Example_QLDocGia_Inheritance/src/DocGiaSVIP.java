/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class DocGiaSVIP extends DocGia{
    float giamgia;

    public DocGiaSVIP() {
        super();
        giamgia = 0;
    }
    public DocGiaSVIP(int ma, String ten, float giamgia) {
        super(ma, ten);
        this.giamgia = giamgia;
    }

    public float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(float giamgia) {
        this.giamgia = giamgia;
    }
    
    void xuatDGSVIP()
    {
        xuat();
        System.out.println("Giam gia: " + giamgia);
    }
}
