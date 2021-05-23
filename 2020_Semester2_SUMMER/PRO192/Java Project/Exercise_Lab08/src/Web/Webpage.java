/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Base.Img;
import Base.Tag;
import Core.Paragraph;
import MyLib.MyValidation;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Webpage {
    final int MAX = 100;
    Tag[] list;
    int count;
    
    public Webpage()
    {
        list = new Tag[MAX];
        count = 0;
    }
    
    void insertTag(Tag x)
    {
        if (count >= MAX)
            System.out.println("The list is full!");
        else
        {
            list[count] = x;
            count++;
            System.out.println("Added successfully!");
        }
    }
    
    void deleteTag(String name)
    {
        int iCheck = -1; // Not found

        for (int i = 0; i < count; i++)
        {
            if (list[i].getName().equals(name))
            {
                iCheck = 1;
                for (int j = i; j < count; j++)
                {
                    list[j] = list[j+1];
                }
                count--;
                break;
            }
        }
        
        if (iCheck != -1)
            deleteTag(name);
        else
            System.out.println("Delete done!");
    }
    
    void displayWebPage()
    {
        for (int i = 0; i < count; i++)
            list[i].format();
    }
    
    void displayParagraph()
    {
        for (int i = 0; i < count; i++)
            if (list[i] instanceof Paragraph)
                list[i].format();
    }
    
    public static void main(String[] args) {
        Webpage obj = new Webpage();
        int choice;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("------------------------");
            System.out.println("Menu to choose:");
            System.out.println("1. Insert an img with width and height");
            System.out.println("2. Insert an img with top and left position");
            System.out.println("3. Insert a paragraph");
            System.out.println("4. Display a webpage");
            System.out.println("5. Delete all tags with name");
            System.out.println("6. Display all paragraphs");
            System.out.println("7. Exit");
            sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1:
                    System.out.println("------------------------");
                    System.out.println("Add a new img");
                    
                    String name;
                    do {
                        System.out.println("Enter the name: ");
                        sc = new Scanner(System.in);
                        name = sc.nextLine();
                    } while (MyValidation.checkEmptyString(name));
                    
                    String content;
                    do {
                        System.out.println("Enter the content: ");
                        sc = new Scanner(System.in);
                        content = sc.nextLine();
                    } while (MyValidation.checkEmptyString(content));
                    
                    String src;
                    do {
                        System.out.println("Enter the src: ");
                        sc = new Scanner(System.in);
                        src = sc.nextLine();
                    } while (MyValidation.checkEmptyString(src));
                    
                    int width;
                    do {
                        System.out.println("Enter the width > 0: ");
                        sc = new Scanner(System.in);
                        width = sc.nextInt();
                    } while (!MyValidation.checkIntNumMin(width, 1));
                    
                    int height;
                    do {
                        System.out.println("Enter the height > 0: ");
                        sc = new Scanner(System.in);
                        height = sc.nextInt();
                    } while (!MyValidation.checkIntNumMin(height, 1));
                    
                    Tag newImg = new Img(src, width, height, name, content);
                    obj.insertTag(newImg);
                    break;
                    
                case 2:
                    System.out.println("------------------------");
                    System.out.println("Add a new img");

                    do {
                        System.out.println("Enter the name: ");
                        sc = new Scanner(System.in);
                        name = sc.nextLine();
                    } while (MyValidation.checkEmptyString(name));
                    
                    do {
                        System.out.println("Enter the content: ");
                        sc = new Scanner(System.in);
                        content = sc.nextLine();
                    } while (MyValidation.checkEmptyString(content));
             
                    do {
                        System.out.println("Enter the src: ");
                        sc = new Scanner(System.in);
                        src = sc.nextLine();
                    } while (MyValidation.checkEmptyString(src));
                    
                    int top;
                    do {
                        System.out.println("Enter the top position > 0: ");
                        sc = new Scanner(System.in);
                        top = sc.nextInt();
                    } while (!MyValidation.checkIntNumMin(top, 1));
                    
                    int left;
                    do {
                        System.out.println("Enter the left position > 0: ");
                        sc = new Scanner(System.in);
                        left = sc.nextInt();
                    } while (!MyValidation.checkIntNumMin(left, 1));
                    
                    Tag nImg = new Core.Img(src, top, left, name, content);
                    obj.insertTag(nImg);
                    break;
                    
                case 3:
                    System.out.println("------------------------");
                    System.out.println("Add a new paragraph");
                    
                    do {
                        System.out.println("Enter the name: ");
                        sc = new Scanner(System.in);
                        name = sc.nextLine();
                    } while (MyValidation.checkEmptyString(name));
                    
                    do {
                        System.out.println("Enter the content: ");
                        sc = new Scanner(System.in);
                        content = sc.nextLine();
                    } while (MyValidation.checkEmptyString(content));
                    
                    String color;
                    do {
                        System.out.println("Enter the color: ");
                        sc = new Scanner(System.in);
                        color = sc.nextLine();
                    } while (MyValidation.checkEmptyString(color));
                    
                    Tag newPgr = new Paragraph(color, name, content);
                    obj.insertTag(newPgr);
                    break;
                    
                case 4:
                    System.out.println("------------------------");
                    System.out.println("A webpage: ");
                    obj.displayWebPage();
                    break;
                    
                case 5:
                    System.out.println("------------------------");
                    System.out.println("Delete with name");
                    
                    String sName;
                    do {
                        System.out.println("Enter a name to delete: ");
                        sc = new Scanner(System.in);
                        sName = sc.nextLine();
                    } while (MyValidation.checkEmptyString(sName));
                    obj.deleteTag(sName);
                    break;
                    
                case 6:
                    System.out.println("------------------------");
                    obj.displayParagraph();
                    break;
            }
        } while (choice != 7);
    }
}
