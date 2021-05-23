/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Validation.MyValidation;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class SubMenu extends ArrayList<String> {
    int subIndex;
    
    public SubMenu(int subIndex) {
        this.subIndex = subIndex;
    }
    public int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        int choice = 0;
        do {
            for (int i = 0; i < this.size(); i++) {
                System.out.println("\t" + subIndex + "." + (i+1) + ". " + this.get(i) + ".\n");
            }
            System.out.print("\t\tYour choice: ");
            try {
                sc = new Scanner(System.in);
                choice = sc.nextInt();
                if (choice < 1 || choice > this.size())
                    throw new Exception();
                cont = false;
            } catch (Exception e) {
                System.out.println("Please enter number between 1 and " + this.size() + "!");
                cont = true;
                MyValidation.getEnter("Press Enter to enter again...");
            }
        } while (cont);
        
        return choice;
    }
}

