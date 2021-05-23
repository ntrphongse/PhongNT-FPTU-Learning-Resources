/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgExtend;

import MyLib.MyValidation;
import PkgBasic.Book;
import PkgBasic.DetectiveBook;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class BookList{
    final int MAX = 100;
    final int MAXYEAR = 2020;
    private Book[] arr;
    private int count;

    public BookList() {
        arr = new Book[MAX];
        count = 0;
    }

    public Book[] getArr() {
        return arr;
    }
    
    public int getCount() {
        return count;
    }

    public void Add(Book x)
    {
        if (count < MAX)
        {
            arr[count] = x;
            count++;
            System.out.println("Added successfully!");
        }
        else
            System.out.println("The list is full!");
    }
    
    public void Delele(String code)
    {
        int pos = -1;
        for (int i = 0; i < count; i++)
            if (arr[i].getCode().equals(code))
            {
                pos = i;
                break;
            }
        if (pos != -1)
        {
            for (int i = pos; pos < count; pos++)
                arr[i] = arr[i+1];
            count--;
            System.out.println("Delete successfully!");
        }
        else
            System.out.println("No such a Book to delete");
    }
    
    public void Update(String code)
    {
        int pos = -1;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++)
            if (arr[i].getCode().equals(code))
            {
                pos = i;
                break;
            }
        if (pos != -1)
        {
            System.out.println("Update information for the book with the code: " + code);
            
            String title;
            do {
                System.out.println("Enter new Title: ");
                sc = new Scanner(System.in);
                title = sc.nextLine();
            } while (MyValidation.checkEmptyString(title));
            arr[pos].setTitle(title);
            
            if (arr[pos] instanceof DetectiveBook)
            {
                int price;
                do {
                    System.out.println("Enter new Price > 0: ");
                    sc = new Scanner(System.in);
                    price = sc.nextInt();
                } while (!MyValidation.checkIntNumMin(price, 1));
                ((DetectiveBook)arr[pos]).setPrice(price);
                
                int yop;
                do {
                    System.out.println("Enter Year of Publication > 0: ");
                    sc = new Scanner(System.in);
                    yop = sc.nextInt();
                } while (!MyValidation.checkIntNumber(yop, 1, MAXYEAR));
                ((DetectiveBook)arr[pos]).setYearofpublication(yop);
            }
            else if (arr[pos] instanceof ScienceBook)
            {
                String type;
                do
                {
                    System.out.println("Enter new Type (physical, mathematic or chemistry): ");
                    sc = new Scanner(System.in);
                    type = sc.nextLine();
                } while (!MyValidation.checkType(type));
                ((ScienceBook)arr[pos]).setType(type);
            }
            System.out.println("Update information succesfully!");
            System.out.println("\tUpdated information: " + arr[pos].toString());
        }
        else
            System.out.println("No such a Book to delete");
    }
    
    // Display all detective Books in array and the sum of price of all detective books
    public void displayDetectiveBooks()
    {
        System.out.print("List of Detective Books: ");
        int sumPrice = 0;
        for (int i = 0; i < count; i++)
        {
            if (arr[i] instanceof DetectiveBook)
            {
                System.out.print(arr[i].toString() + "; ");
                sumPrice += ((DetectiveBook)arr[i]).getPrice();
            }
        }
        System.out.println("");
        System.out.println("\tTotal price: " + sumPrice);
    }
    
    public void displayScienceBooks()
    {
        System.out.println("List of Science Books: ");
        for (int i = 0; i < count; i++)
            if (arr[i] instanceof ScienceBook)
                System.out.print(arr[i].toString() + "; ");
        System.out.println("");
    }
    
    public Book Search(String code)
    {
        for (int i = 0; i < count; i++)
            if (arr[i].getCode().equals(code))
                return arr[i];
        return null;
    }
    
    public Book[] Search(int YearOfPublish)
    {
        Book[] sArr = new Book[MAX];
        int sCount = 0;
        for (int i = 0; i < count; i++)
            if (arr[i] instanceof DetectiveBook)
                if (((DetectiveBook)arr[i]).getYearofpublication() == YearOfPublish)
                {
                    sArr[sCount] = arr[i];  
                    sCount++;
                }
        return sArr;
    }
    
    public boolean search(String title)
    {
        for (int i = 0; i < count; i++)
            if (arr[i].getTitle().toLowerCase().equals(title.toLowerCase()))
                return true;
        return false;
    }
}
