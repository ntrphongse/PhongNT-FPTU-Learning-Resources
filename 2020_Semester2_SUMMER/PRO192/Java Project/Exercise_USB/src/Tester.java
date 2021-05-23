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
        MobilePhone mp1 = new MobilePhone(1000, 111, 256);
        MobilePhone mp2 = new MobilePhone(1200, 222, 128);
        
        System.out.println(mp1.toString());
        System.out.println(mp2.toString());
        
        USB.changeModel();
        
        System.out.println("");
        System.out.println(mp1.toString());
        System.out.println(mp2.toString());
    }
    
}
