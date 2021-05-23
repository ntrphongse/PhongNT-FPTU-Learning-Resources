/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLib;

import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Menu {
    public static void main(String[] args) {
        boolean nhaptiep = true;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            do
            {
                nhaptiep = true;
                try {
                    System.out.println("------------------");
                    System.out.println("Menu to choose:");
                    System.out.println("1. Load data");
                    System.out.println("2. Print out the name that is the most popular name for male and female");
                    System.out.println("3. Increase the number of Person used of a given name");
                    System.out.println("\tEnter your choice:");
                    choice = MyValidation.inputIntNumber(1, 3);
                    
                    nhaptiep = false;
                }
                catch (Exception e) {
                    System.out.println("Please enter an integer from 1 to 3!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            switch (choice)
            {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
            }
        } while (choice >= 1 && choice < 3);
    }
}
