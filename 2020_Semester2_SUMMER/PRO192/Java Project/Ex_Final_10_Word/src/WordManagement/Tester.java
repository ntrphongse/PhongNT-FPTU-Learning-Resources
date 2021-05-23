/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WordManagement;

import MyLib.MyValidation;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        boolean nhaptiep = true;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        WordManager obj = new WordManager();
        do
        {
            do
            {
                nhaptiep = true;
                try {
                    System.out.println("------------------");
                    System.out.println("Menu to choose:");
                    System.out.println("1. Load words");
                    System.out.println("2. Print out words that begin with a prefix");
                    System.out.println("3. Print out all the words and their length");
                    System.out.println("4. Exit");
                    System.out.println("\tEnter your choice:");
                    choice = MyValidation.inputIntNumber(1, 4);
                    
                    nhaptiep = false;
                }
                catch (Exception e) {
                    System.out.println("Please enter an integer from 1 to 4!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            switch (choice)
            {
                case 1:
                    System.out.println("----------------------");
                    System.out.println("Loading data...");
                    obj.loadData();
                    if (obj.list.isEmpty())
                        System.out.println("Failed to load data! Please check again!");
                    else
                        System.out.println("Loaded data successfully!");
                    break;
                case 2:
                    if (obj.list.isEmpty())
                        System.out.println("Data is not loaded yet! Try to load the data first!");
                    else {
                        System.out.println("----------------------");
                        System.out.println("Print out the words that begin with a prefix...");
                        System.out.println("-----");
                        String prefix = "";
                        nhaptiep = true;
                        do
                        {
                            try
                            {
                                System.out.println("\tEnter a prefix: ");
                                prefix = MyValidation.inputString();
                                nhaptiep = false;
                            }
                            catch (Exception e)
                            {
                                System.out.println("Please enter a not-empty prefix!");
                                nhaptiep = true;
                            }
                        } while (nhaptiep);
                        System.out.println("-----");
                        System.out.println("Printing out the words...");
                        obj.getSuggestion(prefix);
                    }
                    break;
                case 3:
                    if (obj.list.isEmpty())
                        System.out.println("Data is not loaded yet! Try to load the data first!");
                    else {
                        System.out.println("----------------------");
                        System.out.println("Print out all the words and their length...");
                        obj.printWordLength();
                    }
                    break;
                case 4:
                    break;
            }
        } while (choice >= 1 || choice <= 3);
    }
}
