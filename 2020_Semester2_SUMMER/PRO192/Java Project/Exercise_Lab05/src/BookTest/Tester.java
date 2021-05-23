/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookTest;

import MyLib.MyValidation;
import PkgBasic.Book;
import PkgBasic.DetectiveBook;
import PkgExtend.BookList;
import PkgExtend.ScienceBook;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Tester {
    public static void main(String[] args) {
        int choice = 0;
        final int MAXYEAR = 2020;
        BookList obj = new BookList();
        do
        {
            System.out.println("Menu to choose: ");
            System.out.println("1. Add a Detective Book");
            System.out.println("2. Add a Science Book");
            System.out.println("3. Delete a book");
            System.out.println("4. Update a book");
            System.out.println("5. Display All DetectiveBooks");
            System.out.println("6. Display All ScienceBooks");
            System.out.println("7. Search by code");
            System.out.println("8. Search by title");
            System.out.println("9. Search and display all books by Year of publication");
            System.out.println("10. Exit");
            
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("---------------------");
                    System.out.println("Add a Detective Book!");
                    System.out.println("Enter the code: ");
                    sc = new Scanner(System.in);
                    String code = sc.nextLine();
                    while (!(MyValidation.checkCode(code)))
                    {
                        System.out.println("Wrong format for code! Please enter again!");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                    }
                    
                    while (!(MyValidation.checkUniqueCode(obj, code)))
                    {
                        System.out.println("Not a unique code! Please enter again!");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                    }                    
                    
                    String title;
                    do {
                        System.out.println("Enter the title: ");
                        sc = new Scanner(System.in);
                        title = sc.nextLine();
                    } while (MyValidation.checkEmptyString(title));
                                    
                    int price;
                    do {
                        System.out.println("Enter the price > 0: ");
                        sc = new Scanner(System.in);
                        price = sc.nextInt();
                    } while (!MyValidation.checkIntNumMin(price, 1));
                    
                    int yop;
                    do {
                        System.out.println("Enter Year of Publication > 0: ");
                        sc = new Scanner(System.in);
                        yop = sc.nextInt();
                    } while (!MyValidation.checkIntNumber(yop, 1, MAXYEAR));
                    
                    Book DB;
                    DB = new DetectiveBook(price, yop, code, title);
                    obj.Add(DB);
                    break;
                    
                case 2:
                    System.out.println("---------------------");
                    System.out.println("Add a Science Book!");
                    System.out.println("Enter the code: ");
                    sc = new Scanner(System.in);
                    code = sc.nextLine();
                    while (!MyValidation.checkCode(code))
                    {
                        System.out.println("Wrong format for code! Please enter again!");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                    }
                    
                    while (!(MyValidation.checkUniqueCode(obj, code)))
                    {
                        System.out.println("Not a unique code! Please enter again!");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                    }
                    
                    do {
                        System.out.println("Enter the title: ");
                        sc = new Scanner(System.in);
                        title = sc.nextLine();
                    } while (MyValidation.checkEmptyString(title));
                    
                    String type;
                    do
                    {
                        System.out.println("Enter the type (physical, mathematic or chemistry): ");
                        sc = new Scanner(System.in);
                        type = sc.nextLine();
                    } while (!MyValidation.checkType(type));
                    
                    Book SB;
                    SB = new ScienceBook(type, code, title);
                    obj.Add(SB);
                    break;
                    
                case 3:
                    System.out.println("---------------------");
                    System.out.println("Delete a Book by code!");
                    System.out.println("Enter the code: ");
                    sc = new Scanner(System.in);
                    String dCode = sc.nextLine();
                    if (!MyValidation.checkCode(dCode))
                        System.out.println("No such a book!");
                    else
                        obj.Delele(dCode);
                    break;
                    
                case 4:
                    System.out.println("---------------------");
                    System.out.println("Update a book!");
                    System.out.println("Enter the code: ");
                    sc = new Scanner(System.in);
                    String uCode = sc.nextLine();
                    if (!MyValidation.checkCode(uCode))
                        System.out.println("No such a book!");
                    else
                        obj.Update(uCode);
                    break;
                    
                case 5:
                    System.out.println("---------------------");
                    obj.displayDetectiveBooks();
                    break;
                    
                case 6:
                    System.out.println("---------------------");
                    obj.displayScienceBooks();
                    break;
                    
                case 7:
                    System.out.println("---------------------");
                    System.out.println("Search by code!");
                    System.out.println("Enter code to search: ");
                    sc = new Scanner(System.in);
                    String sCode = sc.nextLine();
                    if (!MyValidation.checkCode(sCode))
                        System.out.println("No such a book!");
                    else
                    {
                        Book sBook = obj.Search(sCode);
                        if (sBook != null)
                        {
                            System.out.println("Found! \t " + sBook.toString());
                        }
                            
                        else
                            System.out.println("No such a book!");
                    }
                    break;
                    
                case 8:
                    System.out.println("---------------------");
                    System.out.println("Search by Title");
                    System.out.println("Enter the title to search: ");
                    sc = new Scanner(System.in);
                    String sTitle = sc.nextLine();
                    if (obj.search(sTitle))
                        System.out.println("There is a book with the title " + sTitle);
                    else
                        System.out.println("No such a book!");
                    break;
                    
                case 9:
                    System.out.println("---------------------");
                    System.out.println("Search all by Year of Publication");
                    System.out.println("Enter year to search: ");
                    sc = new Scanner(System.in);
                    int sYear = sc.nextInt();
                    Book[] sObj = obj.Search(sYear);
                    if (sObj[0] == null)
                        System.out.println("No such a book!");
                    else
                    {
                        System.out.println("\tBook(s) with the Year of Publication " + sYear);
                        int sCount = 0;
                        while (sObj[sCount] != null)
                        {
                            System.out.println("\t"+sObj[sCount].toString());
                            sCount++;
                        }
                    }
                    
            }
        } while (choice != 10);
    }
}
