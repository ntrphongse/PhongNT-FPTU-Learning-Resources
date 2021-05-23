/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C;

import B.CourseList;
import MyLib.MyValidation;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Test {
    public static void main(String[] args) {
        int choice = 0;
        CourseList obj = new CourseList();
        boolean nhaptiep = true;
        Scanner sc = new Scanner(System.in);
        do
        {
            nhaptiep = true;
            do
            {
                System.out.println("Menu to choose:");
                System.out.println("1. Add a new Course");
                System.out.println("2. Update courses by hours");
                System.out.println("3. Exit");
                sc = new Scanner(System.in);
                try
                {
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 3)
                        throw new Exception("Please enter number between 1 and 3!");
                    nhaptiep = false;
                }
                catch (Exception e)
                {
                    System.out.println("Please enter from 1 to 3!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            switch (choice)
            {
                case 1:
                    System.out.println("-----------------");
                    System.out.println("Add a new course!");
                    
                    nhaptiep = true;
                    String Name = "";
                    int Hours = 0;
                    do
                    {
                        try
                        {
                            System.out.println("Enter Name of the course:");
                            sc = new Scanner(System.in);
                            Name = sc.nextLine();
                            if (MyValidation.checkEmptyString(Name))
                                throw new Exception("Please enter a valid Name!");
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    nhaptiep = true;
                    do
                    {
                        try
                        {
                            System.out.println("Enter Hours of the course:");
                            Hours = MyValidation.inputIntNumber(1, 3);
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("Please enter Hours between 1 and 3!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    if (obj.addCourse(Name, Hours))
                        System.out.println("Added new course successfully!");
                    else
                        System.out.println("Failed to add! Please try again!");

                    break;
                case 2:
                    nhaptiep = true;
                    int OldHours = 0, NewHours = 0;
                    do
                    {
                        try
                        {
                            System.out.println("Enter Hours of the course to update:");
                            OldHours = MyValidation.inputIntNumber(1, 3);
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("Please enter Hours between 1 and 3!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    nhaptiep = true;
                    do
                    {
                        try
                        {
                            System.out.println("Enter New Hours of the course to update:");
                            NewHours = MyValidation.inputIntNumber(1, 3);
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("Please enter Hours between 1 and 3!");
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    obj.UpdateCourse(OldHours, NewHours);
                    break;
                case 3:
                    break;
            }
        } while (choice >= 1 && choice < 3);
    }
    
    
}
