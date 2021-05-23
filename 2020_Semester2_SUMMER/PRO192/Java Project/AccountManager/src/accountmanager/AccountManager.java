/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanager;

/**
 *
 * @author Hp
 */
public class AccountManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Account a = new Account(100, "Thi B");
        Account b = new Account(200, "Van A");
        a.output();
        b.output();
        
        // thay rate = 0.2
        Account.changeRate(0.2f);
        a.output();
        b.output();
        
    }
    
}
