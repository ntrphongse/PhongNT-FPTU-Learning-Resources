/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe_printer;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class PE_Printer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        PrinterList obj = new PrinterList();
        Scanner s = new Scanner(System.in);
        do 
        {
            System.out.println("Menu to choose:");
            System.out.println("1. Add new Printer");
            System.out.println("2. Update Printer based on ModelNumer");
            System.out.println("3. Print the list in descending order of Price and then descending order of Type");
            System.out.println("4. Exit");
            s = new Scanner(System.in);
            choice = s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("---------------");
                    System.out.println("Add a new Printer!");
                    String ModelNumber;
                    do {
                        System.out.println("Enter the Model Number:");
                        s = new Scanner(System.in);
                        ModelNumber = s.nextLine();
                        if (obj.checkModel(ModelNumber))
                            System.out.println("Model Number existed! Please try again!");
                    } while (obj.checkModel(ModelNumber));
                    System.out.println("Enter Type:");
                    s = new Scanner(System.in);
                    String Type = s.nextLine();
                    
                    String isColored;
                    do {
                        System.out.println("Is it colored? (y/n)");
                        s = new Scanner(System.in);
                        isColored = s.nextLine();
                    } while (!(isColored.equalsIgnoreCase("y") || isColored.equalsIgnoreCase("n")));
                    boolean isColor = true;
                    if (isColored.equalsIgnoreCase("y"))
                        isColor = true;
                    else if (isColored.equalsIgnoreCase("n"))
                        isColor = false;
                    System.out.println("Enter Price:");
                    s = new Scanner(System.in);
                    double Price = s.nextDouble();
                    Printer nPrinter = new Printer(ModelNumber, Type, isColor, Price);
                    if (obj.addPrinter(nPrinter))
                        System.out.println("Added successfully!");
                    else
                        System.out.println("Failed to add~! Please try again!");
                    break;
                case 2:
                    System.out.println("----------------");
                    System.out.println("Update Printer based on Model Number!");
                    System.out.println("Enter Model Number of Printer to update:");
                    s = new Scanner(System.in);
                    String sMN = s.nextLine();
                    if (!obj.checkModel(sMN))
                        System.out.println("No such a printer to update!");
                    else
                    {
                        System.out.println("Enter new Type:");
                        s = new Scanner(System.in);
                        Type = s.nextLine();
                        System.out.println("Is it colored? (y/n)");
                        do {
                            s = new Scanner(System.in);
                            isColored = s.nextLine();
                        } while (!(isColored.equalsIgnoreCase("y") || isColored.equalsIgnoreCase("n")));
                        isColor = true;
                        if (isColored.equalsIgnoreCase("y"))
                            isColor = true;
                        else if (isColored.equalsIgnoreCase("n"))
                            isColor = false;
                        System.out.println("Enter Price:");
                        s = new Scanner(System.in);
                        Price = s.nextDouble();
                        Printer uPrinter = new Printer(sMN, Type, isColor, Price);
                        if (obj.updateModel(sMN, uPrinter))
                            System.out.println("Updated successfully!");
                        else
                            System.out.println("Failed to update~! Please try again!");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (choice >= 1 || choice < 4);
    }
    
}
