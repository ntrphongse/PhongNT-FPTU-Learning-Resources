/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C;

import A.Video;
import B.VideoList;
import MyLib.MyValidation;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Test {
    public static void main(String[] args) {
        int choice = 0;
        VideoList obj = new VideoList();
        boolean nhaptiep = true;
        Scanner sc = new Scanner(System.in);
        do
        {
            do
            {
                try
                {
                    System.out.println("--------------------");
                    System.out.println("Menu to choose:");
                    System.out.println("1. Add a new video");
                    System.out.println("2. Search video by title");
                    System.out.println("3. Exit");
                    System.out.println("Choose option: ");
                    choice = MyValidation.inputIntNumber(1, 3);
                    nhaptiep = false;
                }
                catch (Exception e)
                {
                    System.out.println("Please enter a number between 1 and 3!!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            switch (choice)
            {
                case 1:
                    nhaptiep = true;
                    String title = "";
                    int year = 0;
                    System.out.println("--------------------");
                    System.out.println("Add a new video!");
                    do
                    {
                        try {
                            System.out.println("Enter the title of Video: ");
                            title = MyValidation.inputTitle();
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("Please enter a not-empty title!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    do {
                        try {
                            System.out.println("Enter the year of Video: ");
                            year = MyValidation.inputYear();
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("Please enter an integer year <= " + Calendar.getInstance().get(Calendar.YEAR) + "!!!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    if (obj.addVideo(new Video(title, year)))
                        System.out.println("Added successfully!");
                    else
                        System.out.println("Failed to add! Please check again!");
                    break;
                    
                case 2:
                    System.out.println("--------------------");
                    System.out.println("Search video by title!");
                    String sTitle = "";
                    nhaptiep = true;
                    do {
                        try {
                            System.out.println("Enter a title to search: ");
                            sTitle = MyValidation.inputTitle();
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("Please enter a not-empty title!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    Video sResult = obj.searchByTitle(sTitle);
                    if (sResult == null) System.out.println("No such a book!");
                    else
                    {
                        System.out.println("Found!");
                        System.out.println("\tTitle: " + sResult.getTitle());
                        System.out.println("\tYear: " + sResult.getYear());
                    }
                    
                    break;
                case 3:
                    break;
            }
        } while (choice >= 1 && choice < 3);
    }
}
