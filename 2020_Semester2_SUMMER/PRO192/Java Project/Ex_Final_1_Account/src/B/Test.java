/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import A.Account;
import A.AccountList;
import MyLib.MyValidation;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Test {
    public static void main(String[] args) {
        int choice = 1;
        AccountList obj = new AccountList();
        do
        {
            Scanner sc = new Scanner(System.in);
            boolean nhaptiep = true;
            do
            {
                System.out.println("Menu to choose:");
                System.out.println("1. Add a new Account");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                sc = new Scanner(System.in);
                try
                {
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 3)
                        throw new Exception("Please enter integer from 1 to 3!");
                    nhaptiep = false;
                }
                catch (Exception e)
                {
                    System.out.println("Please enter integer from 1 to 3!");
                    nhaptiep = true;
                }
            } while (nhaptiep);
            
            switch (choice)
            {
                case 1:
                    System.out.println("-------------------------");
                    System.out.println("Add a new Account");
                    
                    String email = "";
                    String password = "";
                    nhaptiep = true;
                    do
                    {
                        try
                        {
                            System.out.println("Enter email: ");
                            sc = new Scanner(System.in);
                            email = sc.nextLine();
                            if (!MyValidation.checkEmail(email))
                            {
                                throw new Exception("Please enter a valid email!");
                            }
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
                            System.out.println("Enter password: ");
                            password = sc.nextLine();
                            if (!MyValidation.checkPassword(password))
                                throw new Exception("Please enter a valid password with the strength of 8 to 12 characters and only contain a-z, A-Z, 0-9!");
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    
                    Account nAcc = new Account(email, password);
                    if(obj.addAccount(nAcc))
                        System.out.println("Added successfully!");
                    else
                        System.out.println("Failed to add! Please check again!");
                    System.out.println("-------------------------");
                    break;
                case 2:
                    // Calls login.
                    // If login returns true ==> "Do you want to update your password?" -> Y
                    System.out.println("-------------------------");
                    System.out.println("Login into an Account");
                    
                    String lEmail = "";
                    String lPassword = "";
                    nhaptiep = true;
                    do
                    {
                        try
                        {
                            System.out.println("Enter email:");
                            sc = new Scanner(System.in);
                            lEmail = sc.nextLine();
                            if (!MyValidation.checkEmail(lEmail))
                                    throw new Exception("Please enter a valid email!");
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
                            System.out.println("Enter password: ");
                            sc = new Scanner(System.in);
                            lPassword = sc.nextLine();
                            if (!MyValidation.checkPassword(lPassword))
                                throw new Exception("Please enter a valid password with the strength of 8 to 12 characters and only contain a-z, A-Z, 0-9!");
                            nhaptiep = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                            nhaptiep = true;
                        }
                    } while (nhaptiep);
                    
                    int cLogin = obj.login(lEmail, lPassword);
                    if (cLogin == -1)
                    {
                        System.out.println("Failed to login!");
                    }
                    else
                    {
                        System.out.println("Login successfully!");
                        System.out.println("-------------------------");
                        nhaptiep = true;
                        String cUpdate = "n";
                        do
                        {
                            try
                            {
                                System.out.println("Do you want to update your password? (y/n)");
                                sc = new Scanner(System.in);
                                cUpdate = sc.nextLine().toLowerCase();
                                if (!(cUpdate.equals("y")) || (cUpdate.equals("n")))
                                    throw new Exception("Please enter y/n!");
                                nhaptiep = false;
                            }
                            catch (Exception e)
                            {
                                System.out.println(e.getMessage());
                                nhaptiep = true;
                            }
                        } while (nhaptiep);
                        
                        if (cUpdate.equals("y"))
                        {
                            System.out.println("-------------------------");
                            System.out.println("Update password...");
                            
                            String nPassword = "";
                            nhaptiep = true;
                            do
                            {
                                try
                                {
                                    System.out.println("Enter new password: ");
                                    sc = new Scanner(System.in);
                                    nPassword = sc.nextLine();
                                    if (!MyValidation.checkPassword(nPassword))
                                        throw new Exception("Please enter a valid password with the strength of 8 to 12 characters and only contain a-z, A-Z, 0-9!");
                                    nhaptiep = false;
                                }
                                catch (Exception e)
                                {
                                    System.out.println(e.getMessage());
                                    nhaptiep = true;
                                }
                            } while (nhaptiep);
                            
                            obj.UpdatePassword(nPassword, cLogin);
                        }
                    }
                    break;
                case 3:
                    break;
            }
        } while (choice >= 1 && choice < 3);
    }
    
}
