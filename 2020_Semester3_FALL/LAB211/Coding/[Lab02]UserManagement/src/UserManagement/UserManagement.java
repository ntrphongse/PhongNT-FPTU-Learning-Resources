/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement;

import Core.Menu;
import Core.SubMenu;
import Core.User;
import DAO.FileDAO;
import Validation.MyValidation;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UserManagement {
    final static String FILE = "user.txt";
    public static void main(String[] args) {
        
        // Delete file content
        PrintWriter w = null;
        try {
            w = new PrintWriter(FILE);
            w.write("");
            w.flush();
        } catch (Exception e) {
        }
        finally {
            if (w != null)
                w.close();
        }
        
        // Main menu
        Menu menu = new Menu();
        menu.add("Create a new User account");
        menu.add("Check if a user is existed");
        menu.add("Search user information by name");
        menu.add("Update user");
        menu.add("Save account to file");
        menu.add("Print list user from file");
        menu.add("Exit");
        
        // Update sub-menu
        SubMenu subMenu = new SubMenu(4);
        subMenu.add("Update user information");
        subMenu.add("Delete user");
        subMenu.add("Go back to main menu");
        
        // Main program
        int choice = 0, subChoice = 0;
        boolean cont = true;
        UserList userList = new UserList();
        Scanner sc = new Scanner(System.in);
        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    // Create user
                    System.out.println("----------------");
                    System.out.println("Create a new user account...");
                    String username = "", FName = "", LName = "", password = "", phone = "", email = "", rePassword = "";
                    // Username
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter username: ");
                            sc = new Scanner(System.in);
                            username = sc.nextLine();
                            username = username.trim();
                            if (!MyValidation.isUsername(username))
                                throw new Exception("Username must be from 5 to 40 characters including a-z, A-Z, 0-9, _, . but not spaces!\nPlease try again...");
                            if (userList.search(username) != null)
                                throw new Exception("Username existed! Please try another username...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // First name
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter First name: ");
                            sc = new Scanner(System.in);
                            FName = sc.nextLine();
                            FName = FName.trim();
                            if (!MyValidation.isName(FName))
                                throw new Exception("First name must be from 2 to 35 characters including a-z and A-Z but no spaces! Please try again...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // Last name
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter Last name: ");
                            sc = new Scanner(System.in);
                            LName = sc.nextLine();
                            LName = LName.trim();
                            if (!MyValidation.isName(LName))
                                throw new Exception("Last name must be from 2 to 35 characters including a-z and A-Z but no spaces! Please try again...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // Password
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter Password: ");
                            sc = new Scanner(System.in);
                            password = sc.nextLine();
                            if (!MyValidation.isPassword(password))
                                throw new Exception("Password must be from 6 to 32 characters including a-z, A-Z, 0-9 and some special characters @, $, !, %, *, #, ?, & !"
                                                    + "\nPlease try again...");
                            password = MyValidation.encrypt(password);
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // Confirm password
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter Password again to confirm: ");
                            sc = new Scanner(System.in);
                            rePassword = sc.nextLine();
                            rePassword = MyValidation.encrypt(rePassword);
                            if (!rePassword.equals(password))
                                throw new Exception("Confirm Password is wrong! Please enter again....");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // Phone number
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter Phone number: ");
                            sc = new Scanner(System.in);
                            phone = sc.nextLine();
                            if (!MyValidation.isPhone(phone))
                                throw new Exception("Phone number must be exactly 10 numbers from 0 to 9! Please try again...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // Email
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter Email: ");
                            sc = new Scanner(System.in);
                            email = sc.nextLine();
                            if (!MyValidation.isEmail(email))
                                throw new Exception("Invalid email address! Please try again...");
                            if (userList.searchByEmail(email) != null)
                                throw new Exception("Email address existed! Please try again with another email address...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    try {
                        userList.addUser(new User(username, FName, LName, password, phone, email));
                        System.out.println("Created new user account successfully!");
                    } catch (Exception e) {
                        System.out.println("Failed to create this user! Please try again!");
                    }
                    MyValidation.getEnter("Press Enter to go back to the main menu...");
                    
                    break;
                    
                case 2:
                    // Check exist user
                    File f = new File(FILE);
                    if (f.length() == 0)
                        System.out.println("The User FILE is empty! Please save accounts to file and try again...");
                    else {
                        System.out.println("----------------");
                        System.out.println("Check if a user exists...");
                        String sUser = "";
                        cont = true;
                        do {                            
                            try {
                                System.out.print("\tEnter username to check: ");
                                sc = new Scanner(System.in);
                                sUser = sc.nextLine();
                                if (MyValidation.isEmptyString(sUser))
                                    throw new Exception("Username cannot be empty! Please try again...");
                                if (!MyValidation.isUsername(sUser))
                                    System.out.println("There is no such a user with the username \"" + sUser + "\"!");
                                else {
                                    if (FileDAO.checkExist(FILE, sUser))
                                        System.out.println("Found a user with the username \"" + sUser + "\"!");
                                    else
                                        System.out.println("There is no such a user with the username \"" + sUser + "\"!");
                                }
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                            }
                        } while (cont);
                        MyValidation.getEnter("Press Enter to go back to the main menu...");
                    }
                    break;
                    
                case 3:
                    // Search user by name
                    if (userList.isEmpty())
                        System.out.println("The user LIST is empty! No user is found...");
                    else {
                        System.out.println("----------------");
                        System.out.println("Search user information by name...");
                        String sName = "";
                        cont = true;
                        do {
                            try {
                                System.out.print("\tEnter search string: ");
                                sc = new Scanner(System.in);
                                sName = sc.nextLine();
                                if (MyValidation.isEmptyString(sName))
                                    throw new Exception("Search string cannot be empty! Please try again...");
                                LinkedList<User> sList = userList.searchByName(sName);
                                if (sList == null || sList.isEmpty())
                                    System.out.println("No such a user to be found!");
                                else {
                                    System.out.println("Found " + sList.size() + " user(s)!");
                                    System.out.printf("%-40s\t%-35s\t%-35s\t%-10s\t%-100s\n",
                                            "Username", "First Name", "Last Name", "Phone Number", "Email");
                                    Iterator<User> iterator = sList.iterator();
                                    while (iterator.hasNext()) {
                                        User nUser = iterator.next();
                                        System.out.printf("%-40s\t%-35s\t%-35s\t%-10s\t%-100s\n",
                                                nUser.getUsername(), nUser.getFName(), nUser.getLName(), nUser.getPhone(), nUser.getEmail());
                                    }
                                }
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                            }
                        } while (cont);
                    }
                    break;
                case 4:
                    // Update user
                    if (userList.isEmpty())
                        System.out.println("The user LIST is empty! No user is found...");
                    else {
                        System.out.println("----------------");
                        System.out.println("Update user...");
                        System.out.println("\tLOGIN");
                        String lUser = "", lPass = "";
                        
                        // Enter username
                        cont = true;
                        do {                  
                            try {
                                System.out.print("\t\tEnter username: ");
                                sc = new Scanner(System.in);
                                lUser = sc.nextLine();
                                if (MyValidation.isEmptyString(lUser))
                                    throw new Exception("Username cannot be empty! Please enter again...");
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                            }
                        } while (cont);
                        
                        // Enter password
                        cont = true;
                        do {                  
                            try {
                                System.out.print("\t\tEnter password: ");
                                sc = new Scanner(System.in);
                                lPass = sc.nextLine();
                                if (MyValidation.isEmptyString(lPass))
                                    throw new Exception("Password cannot be empty! Please enter again...");
                                cont = false;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                cont = true;
                            }
                        } while (cont);
                        
                        if (!(MyValidation.isUsername(lUser) && MyValidation.isPassword(lPass))) {
                            System.out.println("Login FAILED!");
                            MyValidation.getEnter("Press Enter to get back to the main menu...");
                        }
                        else if (!userList.login(lUser, MyValidation.encrypt(lPass))) {
                            System.out.println("Login FAILED! No such a user...");
                            MyValidation.getEnter("Press Enter to get back to the main menu...");
                        }
                        else {
                            System.out.println("Login SUCCESSFULLY!");
                            System.out.println("What do you want to do?");
                            cont = true;
                            do {
                                subChoice = subMenu.getUserChoice();
                                switch (subChoice) {
                                    case 1:
                                        // Update
                                        System.out.println("----------------");
                                        System.out.println("\tUpdate user information...");
                                        User oldUser = userList.search(lUser);
                                        System.out.println("Enter new information or just leave it blank if you don't want to change!");
                                        username = ""; FName = ""; LName = ""; password = ""; phone = ""; email = ""; rePassword = "";

                                        // First name
                                        cont = true;
                                        System.out.println("\tOld First name: " + oldUser.getFName());
                                        do {
                                            try {

                                                System.out.print("\tEnter new First name: ");
                                                sc = new Scanner(System.in);
                                                FName = sc.nextLine();
                                                FName = FName.trim();
                                                if (!MyValidation.isEmptyString(FName) && !MyValidation.isName(FName))
                                                    throw new Exception("First name must be from 2 to 35 characters including a-z and A-Z but no spaces! Please try again...");
                                                else if (MyValidation.isEmptyString(FName))
                                                    FName = oldUser.getFName();
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Last name
                                        cont = true;
                                        System.out.println("\tOld Last name: " + oldUser.getLName());
                                        do {
                                            try {
                                                System.out.print("\tEnter new Last name: ");
                                                sc = new Scanner(System.in);
                                                LName = sc.nextLine();
                                                LName = LName.trim();
                                                if (MyValidation.isEmptyString(LName))
                                                    LName = oldUser.getLName();
                                                else if (!MyValidation.isName(LName))
                                                    throw new Exception("Last name must be from 2 to 35 characters including a-z and A-Z but no spaces! Please try again...");
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Password
                                        cont = true;
                                        boolean iEmpty = false;
                                        do {
                                            try {
                                                System.out.print("\tEnter new Password: ");
                                                sc = new Scanner(System.in);
                                                password = sc.nextLine();
                                                if (MyValidation.isEmptyString(password)) {
                                                    iEmpty = true;
                                                    password = oldUser.getPassword();
                                                }
                                                else if (!MyValidation.isPassword(password))
                                                    throw new Exception("Password must be from 6 to 32 characters including a-z, A-Z, 0-9 and some special characters @, $, !, %, *, #, ?, & !"
                                                                        + "\nPlease try again...");
                                                else
                                                    password = MyValidation.encrypt(password);
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Confirm password
                                        if (!iEmpty) {
                                            cont = true;
                                            do {
                                                try {
                                                    System.out.print("\tEnter new Password again to confirm: ");
                                                    sc = new Scanner(System.in);
                                                    rePassword = sc.nextLine();
                                                    rePassword = MyValidation.encrypt(rePassword);
                                                    if (!rePassword.equals(password))
                                                        throw new Exception("Confirm Password is wrong! Please enter again....");
                                                    cont = false;
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                    cont = true;
                                                }
                                            } while (cont);
                                        }

                                        // Phone number
                                        cont = true;
                                        System.out.println("\tOld Phone number: " + oldUser.getPhone());
                                        do {
                                            try {
                                                System.out.print("\tEnter new Phone number: ");
                                                sc = new Scanner(System.in);
                                                phone = sc.nextLine();
                                                if (MyValidation.isEmptyString(phone))
                                                    phone = oldUser.getPhone();
                                                else if (!MyValidation.isPhone(phone))
                                                    throw new Exception("Phone number must be exactly 10 numbers from 0 to 9! Please try again...");
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Email
                                        cont = true;
                                        System.out.println("\tOld Email: " + oldUser.getEmail());
                                        do {
                                            try {
                                                System.out.print("\tEnter new Email: ");
                                                sc = new Scanner(System.in);
                                                email = sc.nextLine();
                                                if (MyValidation.isEmptyString(email))
                                                    email = oldUser.getEmail();
                                                else if (!MyValidation.isEmail(email))
                                                    throw new Exception("Invalid email address! Please try again...");
                                                else if (userList.searchByEmail(email) != null)
                                                    throw new Exception("Email address existed! Please try again with another email address...");
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Updating...
                                        if (userList.update(oldUser, username, FName, LName, password, phone, email))
                                            System.out.println("Updated user successfully!");
                                        else
                                            System.out.println("Failed to update user! Please check again...");
                                        MyValidation.getEnter("Press Enter to get back to the Update menu...");
                                        cont = true;
                                        break;
                                    case 2:
                                        // Delete
                                        System.out.println("----------------");
                                        System.out.println("\tDelete user...");
                                        oldUser = userList.search(lUser);
                                        switch (MyValidation.isContinue("Do you really want to delete this user (username: " + oldUser.getUsername() + ") (y/n) ?")) {
                                            case 1:
                                                // yes
                                                if (userList.delete(oldUser)) {
                                                    System.out.println("Delete user succesfully!");
                                                    MyValidation.getEnter("Press Enter to get back to the main menu...");
                                                    cont = false;
                                                }
                                                else {
                                                    System.out.println("Failed to delete! Please try again...");
                                                    MyValidation.getEnter("Press Enter to get back to Update menu...");
                                                    cont = true;
                                                }
                                                break;
                                            case 0:
                                                // no
                                                break;
                                        }
                                        break;
                                    case 3:
                                        cont = false;
                                        break;
                                }
                            } while (cont);
                        }
                    }
                    break;
                case 5:
                    // Save to file
                    if (userList.isEmpty())
                        System.out.println("The user LIST is empty! Nothing to save to file. Please try to create some user to operate...");
                    else {
                        System.out.println("----------------");
                        System.out.println("Save users to file...");
                        if (userList.saveAccounts())
                            System.out.println("Save successfully!");
                        else
                            System.out.println("Failed to save users! Please try again...");
                        MyValidation.getEnter("Press Enter to go back to the main menu...");
                    }
                    break;
                case 6:
                    // Print from file
                    LinkedList<User> sUser = FileDAO.loadUser(FILE);
                    if (sUser.isEmpty())
                        System.out.println("No user in FILE to be found! Please save users first...");
                    else {
                        System.out.println("Found " + sUser.size() + " user(s) from FILE!");
                        System.out.printf("%-40s\t%-35s\t%-35s\t%-10s\t%-100s\n",
                                "Username", "First Name", "Last Name", "Phone Number", "Email");
                        Iterator<User> iterator = sUser.iterator();
                        while (iterator.hasNext()) {
                            User nUser = iterator.next();
                            System.out.printf("%-40s\t%-35s\t%-35s\t%-10s\t%-100s\n",
                                    nUser.getUsername(), nUser.getFName(), nUser.getLName(), nUser.getPhone(), nUser.getEmail());
                        }
                    }
                    break;
                case 7:
                    break;
            }
            
        } while (choice != 7);
    }
}
