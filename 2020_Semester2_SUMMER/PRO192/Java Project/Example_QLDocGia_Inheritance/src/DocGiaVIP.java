/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class DocGiaVIP extends DocGia{
    int tienTV;
    
    public DocGiaVIP() {
//        ma = 0;
//        ten = "";
        super();
        tienTV = 0;
        
    }
    public DocGiaVIP(int ma, String ten, int tienTV)
    {
//        this.ma = ma;
//        this.ten = ten;
        super(ma, ten);
        this.tienTV = tienTV;
    }
    
    int getTienTV()
    {
        return tienTV;
    }
    
    void setTienTV(int tienTV)
    {
        if (tienTV > 0)
            this.tienTV = tienTV;
    }
    
//    void xuatDGVip()
//    {
//        xuat();
//        System.out.println("Tien: "+tienTV);
//    }

    @Override
    void xuat() {
        super.xuat(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Tien: " + tienTV);
    }

    
}
