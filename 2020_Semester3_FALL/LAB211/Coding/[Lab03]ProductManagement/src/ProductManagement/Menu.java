/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Menu extends ArrayList<String>{
    public int getUserChoice() {
        int choice = 0;
        boolean cont = true;
        do {
            try {
                System.out.println("Menu to choose:");
                for (int i = 0; i < this.size(); i++)
                    System.out.println((i+1) + ". " + this.get(i));
                System.out.print("\n\tYour choice: ");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                if (choice < 1 || choice > this.size())
                    throw new Exception();
                cont = false;
                
            } catch (Exception e) {
                System.out.println("Please enter number between 1 and " + this.size() + "!");
                cont = true;
            }
            
        } while (cont);
        return choice;
    }
}
