/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonManager;

import DAO.FileDAO;
import DTO.PersonName;
import MyLib.MyValidation;
import java.util.ArrayList;
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
        PersonManager obj = new PersonManager();
        do
        {
            nhaptiep = true;
            do
            {
                try {
                    System.out.println("------------------");
                    System.out.println("Menu to choose:");
                    System.out.println("1. Load data");
                    System.out.println("2. Print out the name that is the most popular name for male and female");
                    System.out.println("3. Increase the number of Person used of a given name");
                    System.out.println("4. Exit");
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
                    System.out.println("------------------");
                    System.out.println("Loading data...");
                    obj.loadData();
                    if (obj.list.isEmpty())
                        System.out.println("Failed to load data!...");
                    else
                        System.out.println("Loaded data successfully!");
                    break;
                case 2:
                    System.out.println("------------------");
                    System.out.println("Print out the most-used name...");
                    if (obj.list.isEmpty())
                        System.out.println("No data to find! Please try to load data first!");
                    else
                    {
                        obj.printName();
                    }
                    break;
                case 3:
                    System.out.println("------------------");
                    System.out.println("Increased the number of persons that use a existed name...");
                    if (obj.list.isEmpty())
                        System.out.println("Failed to progress! Please try to load data first!");
                    else
                    {
                        nhaptiep = true;
                        String iName = "";
                        System.out.println("--------------------------");
                        System.out.println("Lists of existed name:");
                        String name = "";
                        ArrayList<PersonName> list = obj.list;
                        for (PersonName personName : list) {
                            name += personName.getName() + "\t";
                        }
                        System.out.println(name);
                        System.out.println("--------------------------");
                        do
                        {
                            try {
                                
                                System.out.println("Enter a name to increase:");
                                sc = new Scanner(System.in);
                                iName = sc.nextLine();
                                if (MyValidation.checkEmptyString(iName))
                                    throw new Exception("Please enter a non-empty name!");
                                else
                                {
                                    boolean iCheck = false;
                                    for (PersonName personName : list) {
                                        if (personName.getName().equalsIgnoreCase(iName))
                                        {
                                            iCheck = true;
                                            break;
                                        }
                                    }
                                    if (!iCheck)
                                        throw new Exception("Name can't be found in the list! Please check again!");
                                    else
                                        obj.Increase(iName);
                                }
                                nhaptiep = false;
                            } 
                            catch (Exception e) {
                                System.out.println(e.getMessage());
                                nhaptiep = true;
                            }
                        } while (nhaptiep);
                    }
                    break;
                    
                case 4:
                    break;
            }
            
        } while (choice >= 1 && choice <= 3);
    }
}
