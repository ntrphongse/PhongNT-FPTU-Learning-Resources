/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import A.Movie;
import MyLib.MyValidation;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Test {
    public static void main(String[] args) {
        int choice = 0; int check = 0;
        Movie obj = new Movie();
        boolean nhaptiep = true;
        Scanner sc = new Scanner(System.in);
        do {
            nhaptiep = true;
            do {
                try {
                    System.out.println("Menu to choose: ");
                    System.out.println("1. Input");
                    System.out.println("2. Output");
                    System.out.println("3. Sort");
                    System.out.println("4. Exit");
                    System.out.println("Choose:");
                    choice = MyValidation.inputIntNumber(1, 4);
                    nhaptiep = false;
                }
                catch (Exception e) {
                    System.out.println("Please enter an integer choice between 1 and 4!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            switch (choice)
            {
                case 1:
                    System.out.println("-------------------");
                    System.out.println("Input movie information!");
                    obj = new Movie();
                    obj.input();
                    check = 1;
                    break;
                case 2:
                    if (check == 0) System.out.println("No data to display!");
                    else
                    {
                        System.out.println("-----------------------");
                        System.out.println("Information about the movie");
                        obj.output();
                    }
                    
                    break;
                case 3:
                    if (check == 0) System.out.println("No data to display!");
                    else {
                        obj.sortByName();
                        System.out.println("-----------------------");
                        System.out.println("Sorted stars:");
                        obj.output();
                    }
                    break;
                    
                case 4:
                    break;
                    
            }
        } while (choice >= 1 && choice < 4);
    }
}
