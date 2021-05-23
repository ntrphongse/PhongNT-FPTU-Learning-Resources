
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Add a container.");
        menu.add("List all container.");
        menu.add("List containers having volume in a range.");
        menu.add("Remove a container based on ID.");
        menu.add("Exit.");
        
        Scanner sc = new Scanner(System.in);
        ContainerList list = new ContainerList();
        int choice = 0;
        boolean cont = true;
        do {
            try {
                choice = menu.getUserChoice();
                switch (choice) {
                    case 1:
                        System.out.println("----------------");
                        System.out.println("Add a new Container...");
                        String id = "";
                        double volume = 0, netWeight = 0, grossWeight = 0;
                        System.out.print("\tEnter ID: ");
                        sc = new Scanner(System.in);
                        id = sc.nextLine();
                        System.out.print("\tEnter Volume: ");
                        sc = new Scanner(System.in);
                        volume = sc.nextDouble();
                        System.out.print("\tEnter Net Weight: ");
                        sc = new Scanner(System.in);
                        netWeight = sc.nextDouble();
                        System.out.print("\tEnter Gross Weight: ");
                        sc = new Scanner(System.in);
                        grossWeight = sc.nextDouble();
                        if(list.add(new Container(id, volume, netWeight, grossWeight)))
                            System.out.println("Added successfully!");
                        else
                            System.out.println("Failed to add!");                        
                        break;
                    case 2:
                        if (list.isEmpty())
                            System.out.println("The list is empty! Please try to add some Containers to operate...");
                        else {
                            System.out.println("----------------");
                            System.out.println("List all Containers...");
                            list.listAll();
                        }
                        break;
                    case 3:
                        if (list.isEmpty())
                            System.out.println("The list is empty! Please try to add some Containers to operate...");
                        else {
                            System.out.println("----------------");
                            System.out.println("List all Containers having Volume in range...");
                            double minVol = 0, maxVol = 0;
                            System.out.print("\tEnter first volume value: ");
                            sc = new Scanner(System.in);
                            minVol = sc.nextDouble();
                            System.out.print("\tEnter second volume value: ");
                            sc = new Scanner(System.in);
                            maxVol = sc.nextDouble();
                            if (minVol > maxVol) {
                                double t = minVol;
                                minVol = maxVol;
                                maxVol = t;
                            }
                            int numCon = list.listRange(minVol, maxVol);
                            if (numCon == 0)
                                System.out.println("No such a Container to list!");
                        }
                        break;
                    case 4:
                        if (list.isEmpty())
                            System.out.println("The list is empty! Please try to add some Containers to operate...");
                        else {
                            System.out.println("----------------");
                            System.out.println("Remove a Container...");
                            System.out.print("Enter Container ID to remove: ");
                            sc = new Scanner(System.in);
                            String rID = sc.nextLine();
                            if (list.searchContainer(rID) == null)
                                System.out.println("No such a container to remove!");
                            else {
                                if (list.removeContainer(rID))
                                    System.out.println("Removed successfully!");
                                else 
                                    System.out.println("Failed to remove!");
                            }
                            
                        }
                        break;
                    case 5:
                        cont = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 5!");
                cont = true;
            }
            
        } while (cont);
    }
}
