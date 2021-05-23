/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example_interface;

import Bep.DauBep;
import QuanAn.Menu;
import QuanAn.MenuHaiSan;

/**
 *
 * @author Hp
 */
public class Example_Interface {

    Menu tmp;

    public Example_Interface() {
        tmp = new Menu() {
            @Override
            public void HauNuong() {
                System.out.println("Ahihi");
            }

            @Override
            public void NgheuHapXa() {
                System.out.println("La la la");
            }
        };
        
        tmp.NgheuHapXa();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Menu m1 = new DauBep("Dam Vinh Hung");
//        
//        m1.HauNuong();
//        
//        MenuHaiSan m2 = new DauBep("Dam Vinh Hung");
//        m2.MiXaoOcMongTay();
//        
//        Menu.trungluoc();
            Example_Interface ei = new Example_Interface();
        
    }
    
}
