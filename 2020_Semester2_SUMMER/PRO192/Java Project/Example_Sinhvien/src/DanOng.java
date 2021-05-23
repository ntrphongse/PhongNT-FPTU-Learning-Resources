/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class DanOng {
    String tinhtinh;
    String mui;

    public DanOng(String tinhtinh, String mui) {
        this.tinhtinh = tinhtinh;
        this.mui = mui;
    }

    public DanOng() {
        tinhtinh = "tu te";
        mui = "cung duoc";
    }
    
    final void doiTinh()
    {
        tinhtinh = "deu";
        final int max = 100;
        
    }
    
}
