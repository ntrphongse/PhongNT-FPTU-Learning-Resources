/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClockManager;

import Basic.Clock;
import Basic.Menu;
import List.ClockList;
import Validation.MyValidation;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        // Menu here
        Menu menu = new Menu();
        menu.add("Add a new Clock");
        menu.add("Remove a Clock based on ID");
        menu.add("Update a Clock based on ID");
        menu.add("Display all Clocks");
        menu.add("Display Clocks in a range of price");
        menu.add("Quit");
        
        // Main program
        int choice = 0;
        boolean cont;
        ClockList list = new ClockList();
        Scanner sc = new Scanner(System.in);
        do {
            cont = true;
            do {
                try {
                    choice = menu.getUserChoice();
                    cont = false;
                } catch (Exception e) {
                    System.out.println("Please enter option between 1 and 6!");
                    cont = true;
                    MyValidation.getEnter();
                }
            } while (cont);
                
            switch (choice){
                case 1:
                    // Add a Clock
                    String id = "";
                    String manu = "";
                    double price = 0;
                    int guarant = 0;
                    System.out.println("---------------------");
                    System.out.println("Add a new Clock...");
                    cont = true;
                    // Enter ID
                    do {
                        System.out.print("\tEnter Clock ID: ");
                        try {
                            sc = new Scanner(System.in);
                            id = sc.nextLine();
                            if (MyValidation.isEmptyString(id))
                                throw new Exception("ID cannot be empty!");
                            if (list.search(id) != null)
                                throw new Exception("There is a Clock with the same ID in the list already! Please enter a different ID.");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    cont = true;
                    // Enter Manufacturer
                    do {
                        System.out.print("\tEnter Clock Manufacturer: ");
                        try {
                            sc = new Scanner(System.in);
                            manu = sc.nextLine();
                            if (MyValidation.isEmptyString(manu))
                                throw new Exception("Manufacturer cannot be empty!");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    cont = true;
                    // Enter Price
                    do {
                        System.out.print("\tEnter Clock Price: ");
                        try {
                            sc = new Scanner(System.in);
                            price = sc.nextDouble();
                            if (price <= 0)
                                throw new Exception("Price must be > 0!");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    cont = true;
                    // Enter Guarantee
                    do {
                        System.out.print("\tEnter Clock Number of Guarantee Month: ");
                        try {
                            sc = new Scanner(System.in);
                            guarant = sc.nextInt();
                            if (guarant < 0)
                                throw new Exception("No. Guarantee month must be >= 0!");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    if (list.addClock(new Clock(id, manu, price, guarant)))
                        System.out.println("Added successfully!");
                    else
                        System.out.println("Failed to add! Please try again!");
                    MyValidation.getEnter();
                    
                    break;
                case 2:
                    // Remove Clock based on ID
                    if (list.isEmpty()) {
                        System.out.println("No Clocks to remove! Try to add some clocks before processing...");
                        MyValidation.getEnter();
                        break;
                    }
                    System.out.println("---------------------");
                    System.out.println("Remove a Clock...");
                    cont = true;
                    // Enter ID
                    do {
                        System.out.print("\tEnter Clock ID to remove: ");
                        try {
                            sc = new Scanner(System.in);
                            String rID = sc.nextLine();
                            if (MyValidation.isEmptyString(rID))
                                throw new Exception("ID cannot be empty!");
                            if (list.search(rID) == null)
                                throw new Exception("There is no Clock with the ID \"" + rID + "\" in the list to remove!");
                            if (list.removeClock(rID))
                                System.out.println("Remove successfully!");
                            else 
                                throw new Exception("Failed to remove! Please check again.");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                        finally {
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    break;
                case 3:
                    // Update Clock based on ID
                    if (list.isEmpty()) {
                        System.out.println("No Clocks to update! Try to add some clocks before processing...");
                        MyValidation.getEnter();
                        break;
                    }
                    System.out.println("---------------------");
                    System.out.println("Update a Clock...");
                    cont = true;
                    String uID = "";
                    String uManu = "";
                    double uPrice = 0;
                    int uGuarant = 0;
                    Clock oClock = null;
                    // Enter ID
                    do {
                        System.out.print("\tEnter Clock ID to update: ");
                        try {
                            sc = new Scanner(System.in);
                            uID = sc.nextLine();
                            if (MyValidation.isEmptyString(uID))
                                throw new Exception("ID cannot be empty!");
                            oClock = list.search(uID);
                            if (oClock == null)
                                throw new Exception("There is no Clock with the ID \"" + uID + "\" in the list to update!");
                            System.out.println("Found Clock... Updating...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    cont = true;
                    // Enter Manufacturer
                    do {
                        if (oClock != null) {
                            System.out.println("\tOld Manufacturer: " + oClock.getManufacturer());
                            System.out.print("\tEnter new Manufacturer: ");
                            try {
                                sc = new Scanner(System.in);
                                uManu = sc.nextLine();
                                if (MyValidation.isEmptyString(uManu))
                                    throw new Exception("Manufacturer cannot be empty!");
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                                MyValidation.getEnter();
                            }
                        }
                    } while (cont);
                    
                    cont = true;
                    // Enter Price
                    do {
                        if (oClock != null) {
                            System.out.println("\tOld Price: " + oClock.getPrice());
                            System.out.print("\tEnter new Price: ");
                            try {
                                sc = new Scanner(System.in);
                                uPrice = sc.nextDouble();
                                if (uPrice <= 0)
                                    throw new Exception("Price must be > 0!");
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                                MyValidation.getEnter();
                            }
                        }
                    } while (cont);
                    
                    cont = true;
                    // Enter Guarantee
                    do {
                        if (oClock != null) {
                            System.out.println("\tOld Number of Guarantee month: " + oClock.getGuarantee());
                            System.out.print("\tEnter new Number of Guarantee Month: ");
                            try {
                                sc = new Scanner(System.in);
                                uGuarant = sc.nextInt();
                                if (uGuarant < 0)
                                    throw new Exception("No. Guarantee month must be >= 0!");
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                                MyValidation.getEnter();
                            }
                        }
                    } while (cont);
                    Clock nClock = new Clock(uID, uManu, uPrice, uGuarant);
                    if (list.updateClock(oClock, nClock))
                        System.out.println("Updated successfully!");
                    else
                        System.out.println("Failed to update! Please try again!");
                    MyValidation.getEnter();
                    break;
                case 4:
                    // Display all Clocks
                    if (list.isEmpty()) {
                        System.out.println("No Clocks to display! Try to add some clocks before processing...");
                        MyValidation.getEnter();
                        break;
                    }
                    System.out.println("---------------------");
                    System.out.println("Display all Clocks...");
                    list.clockReport();
                    MyValidation.getEnter();
                    break;
                case 5:
                    // Display Clocks in range
                    if (list.isEmpty()) {
                        System.out.println("No Clocks to display! Try to add some clocks before processing...");
                        MyValidation.getEnter();
                        break;
                    }
                    System.out.println("---------------------");
                    System.out.println("Display all Clocks in range...");
                    double Price1 = 0, Price2 = 0;
                    // Price 1
                    do {
                        System.out.print("\tEnter Price 1: ");
                        try {
                            Price1 = sc.nextDouble();
                            if (Price1 <= 0)
                                throw new Exception("Price must be > 0!");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    // Price 2
                    do {
                        System.out.print("\tEnter Price 2: ");
                        try {
                            Price2 = sc.nextDouble();
                            if (Price2 <= 0)
                                throw new Exception("Price must be > 0!");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                            MyValidation.getEnter();
                        }
                    } while (cont);
                    
                    if (Price1 > Price2) {
                        double t = Price1;
                        Price1 = Price2;
                        Price2 = t;
                    }
                    
                    System.out.println("All the Clocks whose price is the range of [" + Price1 + ", " + Price2 + "]");
                    list.rangeClockReport(Price1, Price2);
                    MyValidation.getEnter();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please enter number from 1 to 6...");
                    System.out.print("Press Enter to continue...");
                    MyValidation.getEnter();
                    break;
            }
        } while (choice != 6);
    }
}
