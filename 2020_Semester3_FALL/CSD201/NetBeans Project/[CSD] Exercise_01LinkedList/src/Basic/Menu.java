/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Menu extends ArrayList<String>{
    public int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu to choose:");
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i+1) + ". " + this.get(i) + ".");
        }
        System.out.println("\tChoose an option: ");
        int choice = sc.nextInt();
        return choice;
    }
}
