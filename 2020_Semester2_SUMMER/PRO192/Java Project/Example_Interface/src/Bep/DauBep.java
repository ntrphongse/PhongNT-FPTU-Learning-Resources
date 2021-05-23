/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bep;

import QuanAn.Menu;
import QuanAn.MenuHaiSan;

/**
 *
 * @author Hp
 */
public class DauBep implements Menu, MenuHaiSan{
    String name;

    public DauBep(String name) {
        this.name = name;
    }

    @Override
    public void HauNuong() {
        System.out.println("Cho Hau len vi than ");
        System.out.println("Bo hanh + dau phong");
    }

    @Override
    public void NgheuHapXa() {
        System.out.println("Cho Ngheu vao mieng");
        System.out.println("Nhai it xa");
        System.out.println("Ngoi xong la giai cam");
    }

    @Override
    public void MiXaoOcMongTay() {
        System.out.println("An mi song");
        System.out.println("Uong ngum nuoc");
        System.out.println("Mut mong tay cua minh");
    }

    @Override
    public void GheRangMuoi() {
        System.out.println("Nhin ghe trong ho");
        System.out.println("An muoi");
    }
    
}
