
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
public class StatueManager {
    private static StatueList statueList = new StatueList();
    private static boolean cont = true;
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Menu
        Menu menu = new Menu();
        menu.add("Add a new statue");
        menu.add("Update a statue based on it's ID");
        menu.add("Remove a statue based on it's ID");
        menu.add("List all statue");
        menu.add("Exit");
        
        int choice = 0;
        do {
            System.out.println("");
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    // Add
                    String id = "", author = "";
                    double height = 0, weight = 0;
                    System.out.println("---------------");
                    System.out.println("Adding a new statue");
                    
                    System.out.print("Enter ID: ");
                    sc = new Scanner(System.in);
                    id = sc.nextLine();
                    
                    System.out.print("Enter Author: ");
                    sc = new Scanner(System.in);
                    author = sc.nextLine();
                    
                    System.out.print("Enter Height: ");
                    sc = new Scanner(System.in);
                    height = sc.nextDouble();
                    
                    System.out.print("Enter Weight: ");
                    sc = new Scanner(System.in);
                    weight = sc.nextDouble();
                    
                    Statue s = new Statue(id, author, height, weight);
                    if (statueList.add(s))
                        System.out.println("Added successfully!");
                    else
                        System.out.println("Failed to add! Please try again...");
                    break;
                case 2:
                    // Update
                    if (statueList.isEmpty())
                        System.out.println("The List is empty!");
                    else {
                        id = author = ""; height = weight = 0;
                        System.out.println("---------------");
                        System.out.println("Updating a statue...");

                        System.out.print("Enter Statue ID to update: ");
                        sc = new Scanner(System.in);
                        id = sc.nextLine();

                        Statue sS = statueList.search(id);
                        if (sS == null)
                            System.out.println("Statue with the ID " + id + " doesn't exist! Please try again with another ID...");
                        else {
                            System.out.println("Found statue \"" + id + "\"!");
                            System.out.println("Old Author: " + sS.getAuthor());
                            System.out.print("Enter new Author: ");
                            sc = new Scanner(System.in);
                            author = sc.nextLine();
                            if (author.trim().isEmpty())
                                author = sS.getAuthor();

                            System.out.println("Old Height: " + sS.getHeight());
                            System.out.print("Enter Height: ");
                            sc = new Scanner(System.in);
                            height = sc.nextDouble();

                            System.out.println("Old Weight: " + sS.getWeight());
                            System.out.print("Enter Weight: ");
                            sc = new Scanner(System.in);
                            weight = sc.nextDouble();

                            if (statueList.update(sS, author, height, weight))
                                System.out.println("Updated successfully!");
                            else
                                System.out.println("Failed to update! Please try again...");
                        }
                    }
                    break;
                case 3:
                    // Remove
                    if (statueList.isEmpty())
                        System.out.println("The List is empty!");
                    else {
                        System.out.println("---------------");
                        System.out.println("Removing a statue...");
                        id = "";
                        System.out.print("Enter Statue ID to remove: ");
                        sc = new Scanner(System.in);
                        id = sc.nextLine();

                        Statue sS = statueList.search(id);
                        if (sS == null)
                            System.out.println("Statue with the ID " + id + " doesn't exist! Please try again with another ID...");
                        else {
                            System.out.println("Found statue \"" + id + "\"!");
                            if (statueList.remove(id))
                                System.out.println("Removed successfully!");
                            else
                                System.out.println("Failed to remove! Please try again...");
                        }
                    }
                    break;
                case 4:
                    // List
                    if (statueList.isEmpty())
                        System.out.println("The List is empty!");
                    else {
                        System.out.println("---------------");
                        System.out.println("Listing all statues...");
                        statueList.displayAll();
                    }
                    break;
                case 5:
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
