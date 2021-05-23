/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import A.Electric;
import A.TV;
import MyLib.MyValidation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class TVManager {
    ArrayList<Electric> list;
    
    public TVManager()
    {
        list = new ArrayList<>();
    }
    
    public boolean AddItem(TV x)
    {
        if (x == null)
            return false;
        try {
            list.add(x);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    public void FindAllTV(int m_size)
    {
        if (list.isEmpty())
            System.out.println("The list is empty! Please add at least one TV to progress!");
        else
        {
            int count = 0;
            String result = "";
            for (Electric electric : list) {
                if (((TV)electric).getSize() == m_size)
                {
                    result += "\t" + electric + "\n";
                    count++;
                }
            }
            if (count == 0)
                System.out.println("No TVs with the size of " + m_size + "!");
            else
                System.out.println("Found " + count + " TV(s) with the size of " + m_size
                + "\n" + result);
        }
    }
    
    public void sortByBrand()
    {
        if (list.isEmpty())
            System.out.println("The list is empty! Please add at least one TV to progress!");
        else {
            Collections.sort(list);
            System.out.println("\tSorted list:");
            for (Electric electric : list) {
                System.out.println("\t" + electric);
            }
        }
        
    }
    
    public static void main(String[] args) {
        boolean nhaptiep = true;
        int choice = 0;
        TVManager obj = new TVManager();
        do
        {
            do
            {
                nhaptiep = true;
                try {
                    System.out.println("------------------");
                    System.out.println("Menu to choose:");
                    System.out.println("1. Add a TV");
                    System.out.println("2. Find all TVs based on its size");
                    System.out.println("3. Sort by brand");
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
                    System.out.println("-----------------------");
                    System.out.println("Adding a TV...");
                    
                    String ID = "";
                    String Name = "";
                    int Price = 0;
                    int Size = 0;
                    String Brand = "";
                    nhaptiep = true;
                    do {
                        System.out.println("Enter ID:");
                        try {
                            ID = MyValidation.inputString();
                            nhaptiep = false;
                        }
                        catch (Exception ex) {
                            System.out.println("\tPlease enter a not-empty ID!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    nhaptiep = true;
                    do {
                        System.out.println("Enter Name:");
                        try {
                            Name = MyValidation.inputString();
                            nhaptiep = false;
                        }
                        catch (Exception ex) {
                            System.out.println("\tPlease enter a not-empty Name!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    nhaptiep = true;
                    do {
                        System.out.println("Enter Price (>= 1000 VND):");
                        try {
                            Price = MyValidation.inputIntNumber(1000);
                            nhaptiep = false;
                        }
                        catch (Exception ex) {
                            System.out.println("\tPlease enter an integer number >= 1000 for the Price!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    nhaptiep = true;
                    do {
                        System.out.println("Enter Size (> 0):");
                        try {
                            Size = MyValidation.inputIntNumber(0);
                            nhaptiep = false;
                        }
                        catch (Exception ex) {
                            System.out.println("\tPlease enter an integer number >= 0 for the Size!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    nhaptiep = true;
                    do {
                        System.out.println("Enter Brand (only Samsung or Sony are accepted):");
                        Scanner sc = new Scanner(System.in);
                        try {
                            Brand = sc.nextLine().toLowerCase();
                            if (MyValidation.checkEmptyString(Brand))
                                throw new Exception();
                            Brand = Character.toString(Brand.charAt(0)).toUpperCase() + 
                                    Brand.substring(1);
                            
                            if (!MyValidation.checkString(Brand, "Samsung|Sony"))
                                throw new Exception();
                            nhaptiep = false;
                        }
                        catch (Exception ex) {
                            System.out.println("\tPlease enter only Samsung or Sony for the Brand!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    if (obj.AddItem(new TV(Size, Brand, ID, Name, Price)))
                        System.out.println("Added successfully!");
                    else
                        System.out.println("Failed to add!");
                    break;
                case 2:
                    if (obj.list.isEmpty())
                        System.out.println("The list is empty! Please add at least one TV to progess!");
                    else {
                        System.out.println("-----------------------");
                        System.out.println("Find TVs based on its size...");
                        int m_size = 0;
                        nhaptiep = true;
                        do {
                            System.out.println("Enter Size to find:");
                            try {
                                m_size = MyValidation.inputIntNumber(0);
                                nhaptiep = false;
                            }
                            catch (Exception ex) {
                                System.out.println("\tInvalid size to find! Please enter an integer size > 0 to progress!");
                                nhaptiep = true;
                            }
                        } while (nhaptiep);
                        System.out.println("\tSearching TVs...");
                        obj.FindAllTV(m_size);
                    }
                    break;
                case 3:
                    if (obj.list.isEmpty())
                        System.out.println("The list is empty! Please add at least one TV to progress!");
                    else
                    {
                        System.out.println("-----------------------");
                        System.out.println("Sorting the list with the ascending order based on Brand...");
                        obj.sortByBrand();
                    }
                    break;
                case 4:
                    break;
            }
        } while (choice >= 1 && choice <= 3);
    }
}
