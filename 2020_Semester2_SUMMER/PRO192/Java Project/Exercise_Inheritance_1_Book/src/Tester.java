
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Tester {
    public static void main(String[] args) {
        int choice;
        int code;
        String title;
        do
        {
            System.out.println("Menu to choose");
            System.out.println("\t1 - Create and display a Detective Book");
            System.out.println("\t2 - Create and display a Science Book");
            System.out.println("\t3 - Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("--------------------");
                    System.out.println("Create a Detective Book");
                    
                    do {
                        System.out.println("Enter the code > 0: ");
                        sc = new Scanner(System.in);
                        code = sc.nextInt();
                    } while (code < 0);
                    
                    do {
                        System.out.println("Enter the title: ");
                        sc = new Scanner(System.in);
                        title = sc.nextLine();
                    } while (title.equals(""));
                    
                    int price;
                    do {
                        System.out.println("Enter the price > 0: ");
                        sc = new Scanner(System.in);
                        price = sc.nextInt();
                    } while (price < 0);
                    
                    int yearP;
                    do {
                        System.out.println("Enter year of publication > 0: ");
                        sc = new Scanner(System.in);
                        yearP = sc.nextInt();
                    } while (yearP < 0);
                    
                    Book dBook = new DetectiveBook(code, title, price, yearP);
                    System.out.println("--------------------");
                    System.out.println("Your Dective Book's information");
                    ((DetectiveBook)dBook).outputDetectiveBook();
                    System.out.println("--------------------");
                    break;
                    
                case 2:
                    System.out.println("--------------------");
                    System.out.println("Create a Science Book");
                    
                    do {
                        System.out.println("Enter the code > 0: ");
                        sc = new Scanner(System.in);
                        code = sc.nextInt();
                    } while (code < 0);
                    
                    do {
                        System.out.println("Enter the title: ");
                        sc = new Scanner(System.in);
                        title = sc.nextLine();
                    } while (title.equals(""));
                    
                    String type;
                    do {
                        System.out.println("Enter the type (physical, mathematic or chemistry): ");
                        sc = new Scanner(System.in);
                        type = sc.nextLine();
                    } while (!((type.toLowerCase().equals("physical")) || (type.toLowerCase().equals("mathematic")) || (type.toLowerCase().equals("chemistry"))));
                    
                    Book sBook = new ScienceBook(code, title, type);
                    System.out.println("--------------------");
                    System.out.println("Your Science Book's information");
                    ((ScienceBook)sBook).outputScienceBook();
                    System.out.println("--------------------");
                    break;
                    
                case 3:
                    break;
                default:
                    System.out.println("Error! Please enter from 1 to 3!");
            }
        } while (choice != 3);
    }
    
}
