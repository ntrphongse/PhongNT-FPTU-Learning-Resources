/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductManagement;

import Core.Category;
import Core.Order;
import Core.Product;
import DAO.FileDAO;
import List.CategoryList;
import List.OrderDetail;
import List.OrderList;
import List.ProductList;
import Validation.MyValidation;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ProductManager {
    private static final int MAXQUANTITY = 10000000;
    private static final int MAX = 1000000;
    private static Scanner sc;
    private static boolean cont = true;
    private static String cateFile;
    private static String proFile;
    private static CategoryList cateList = new CategoryList();
    private static ProductList proList = new ProductList(cateList);
    private static OrderList orderList = new OrderList();
    
    public static void main(String[] args) {
        
        // Ask for file name
        System.out.println("\nPreparing...");
        
        // Category Information
        do {
            System.out.println("");
            System.out.print("Enter file name for CATEGORIES Information: ");
            sc = new Scanner(System.in);
            try {
                cateFile = sc.nextLine();
                if (MyValidation.isEmptyString(cateFile))
                    throw new Exception("File name for Category Information cannot be empty! Please try again...");
                File f = new File(cateFile);
                if (!f.exists())
                    throw new Exception("The file does not exist! Please try with another file name...");
                if (f.length() == 0)
                    throw new Exception("The file is empty! Please add some information and try again...");
                CategoryList cateLoad = FileDAO.loadCategory(cateFile);
                if (cateLoad == null)
                    throw new Exception("Failed to load Category! Please try again...");
                cateList = cateLoad;
                System.out.println("\tSuccessfully loaded " + cateList.size() + 
                                    ((cateList.size() <= 1) ? " category" : " categories"));
                cont = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                MyValidation.getEnter("Press Enter to try again...");
                cont = true;
            }
        } while (cont);
        
        System.out.println("");
        
        // Product Information
        do {
            System.out.println("");
            System.out.print("Enter file name for PRODUCTS Information: ");
            sc = new Scanner(System.in);
            try {
                proFile = sc.nextLine();
                if (MyValidation.isEmptyString(proFile))
                    throw new Exception("File name for Product Information cannot be empty! Please try again...");
                File f = new File(proFile);
                if (!f.exists())
                    throw new Exception("The file does not exist! Please try with another file name...");
                if (f.length() == 0)
                    throw new Exception("The file is empty! Please add some information and try again...");
                ProductList proLoad = FileDAO.loadProduct(proFile, cateList);
                if (proLoad == null)
                    throw new Exception("Failed to load Product! Please try again...");
                proList = proLoad;
                System.out.println("\tSuccessfully loaded " + proList.size() + 
                                    ((proList.size() <= 1) ? " product" : " products"));
                cont = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                MyValidation.getEnter("Press Enter to try again...");
                cont = true;
            }
        } while (cont);
        
        // Main menu
        Menu menu = new Menu();
        menu.add("Add new Category");
        menu.add("Update Category");
        menu.add("Add new Product");
        menu.add("Update Product");
        menu.add("Order Product");
        menu.add("Show Order list Report");
        menu.add("Inventory Reports");
        menu.add("Exit");
        
        // Sub Menu - Category
        SubMenu subCate = new SubMenu(2);
        subCate.add("Update Category Information");
        subCate.add("Delete Category");
        subCate.add("Go back to Main Menu");
        
        // Sub Menu - Product
        SubMenu subPro = new SubMenu(4);
        subPro.add("Update Product Information");
        subPro.add("Delete Product");
        subPro.add("Go back to Main Menu");
        
        // Sub Menu - Order
        SubMenu subOrder = new SubMenu(5);
        subOrder.add("Display all Products");
        subOrder.add("Order Products");
        subOrder.add("Go back to Main Menu");
        
        // Main program
        int choice = 0;
        do {
            System.out.println("");
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    // Add category
                    System.out.println("-----------------");
                    System.out.println("Add a new Category...");
                    String id = "", name = "";
                    // Enter ID
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter category ID: ");
                            sc = new Scanner(System.in);
                            id = sc.nextLine();
                            if (!MyValidation.isID(id))
                                throw new Exception();
                            cont = false;
                        } catch (Exception e) {
                            System.out.println("Category ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
                            cont = true;
                        }
                    } while (cont);
                    // Enter Name
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter category Name: ");
                            sc = new Scanner(System.in);
                            name = sc.nextLine();
                            if (!MyValidation.isName(name))
                                throw new Exception();
                            cont = false;
                        } catch (Exception e) {
                            System.out.println("Category name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
                            cont = true;
                        }
                    } while (cont);
                    // Create Category
                    try {
                        Category nCate = new Category(id, name);
                        if (cateList.addCategory(nCate)) {
                            System.out.println("Added Category successfully!");
                            FileDAO.saveCategory(cateFile, cateList);
                        }
                        else
                            throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Failed to add! Please try again...");
                    }
                    MyValidation.getEnter("Press Enter to go back to the Main Menu...");
                    break;
                case 2:
                    // Update category
                    System.out.println("-----------------");
                    System.out.println("Update Category...");
                    if (cateList.isEmpty()) {
                        System.out.println("Category List is empty! Try to add some Categories to operate...");
                        MyValidation.getEnter("Press Enter to get back to the Main Menu...");
                    } else {
                        // Enter ID
                        id = "";
                        cont = true;
                        do {
                            try {
                                System.out.print("\tEnter category ID to update: ");
                                sc = new Scanner(System.in);
                                id = sc.nextLine();
                                if (!MyValidation.isID(id))
                                    throw new Exception();
                                cont = false;
                            } catch (Exception e) {
                                System.out.println("Category ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
                                cont = true;
                            }
                        } while (cont);
                        Category uCate = cateList.searchCategory(id);
                        if (uCate == null) {
                            System.out.println("No such a Category to update!");
                            MyValidation.getEnter("Press Enter to go back to the Main Menu...");
                        }
                        else {
                            System.out.println("Category found! What do you want to do?");
                            int cChoice = 0;
                            do {                            
                                cChoice = subCate.getUserChoice();
                                switch (cChoice) {
                                    case 1:
                                        // Update Info
                                        name = "";
                                        System.out.println("\n\tUpdate category Information...");
                                        System.out.println("Enter new information or just blank to stay unchanged.");
                                        System.out.println("\tCategory ID: " + uCate.getId());
                                        System.out.println("\tOld Category name: " + uCate.getName());
                                        cont = true;
                                        do {
                                            try {
                                                System.out.print("\tNew category Name: ");
                                                sc = new Scanner(System.in);
                                                name = sc.nextLine();
                                                if (MyValidation.isEmptyString(name))
                                                    name = uCate.getName();
                                                else if (!MyValidation.isName(name))
                                                    throw new Exception();
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println("Category name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
                                                cont = true;
                                            }
                                        } while (cont);
                                        if (cateList.updateCategory(uCate, name)) {
                                            System.out.println("Updated successfully!");
                                            FileDAO.saveCategory(cateFile, cateList);
                                        }
                                        else
                                            System.out.println("Failed to update. Please try again...");
                                        MyValidation.getEnter("Press Enter to get back to the Update menu...");
                                        cont = true;
                                        break;
                                    case 2:
                                        // Delete
                                        boolean iCont = MyValidation.isContinue("Do you really want to delete this Category "
                                                                    + "(ID: " + uCate.getId() + ") (y/n)? ");
                                        if (iCont) {
                                            // Delete
                                            try {
                                                if (cateList.deleteCategory(uCate, proList, orderList) != null) {
                                                    FileDAO.saveCategory(cateFile, cateList);
                                                    FileDAO.saveProduct(proFile, proList);
                                                    System.out.println("Deleted successfully!");
                                                    MyValidation.getEnter("Press Enter to get back to the Main Menu...");
                                                    cont = false;
                                                }
                                                else
                                                    throw new Exception();
                                            } catch (Exception e) {
                                                System.out.println("Failed to delete! Please try again...");
                                                MyValidation.getEnter("Press Enter to get back to the Update menu...");
                                                cont = true;
                                            }
                                        } else {
                                            MyValidation.getEnter("Press Enter to get back to the Update menu...");
                                            cont = true;
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
                case 3:
                    // Add product
                    System.out.println("-----------------");
                    System.out.println("Add a new Product...");
                    id = ""; name = "";
                    double price = 0;
                    int quantity = 0;
                    String cateID = "";
                    
                    // Enter ID
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter product ID: ");
                            sc = new Scanner(System.in);
                            id = sc.nextLine();
                            if (!MyValidation.isID(id))
                                throw new Exception();
                            cont = false;
                        } catch (Exception e) {
                            System.out.println("Product ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
                            cont = true;
                        }
                    } while (cont);
                    
                    // Enter Name
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter product Name: ");
                            sc = new Scanner(System.in);
                            name = sc.nextLine();
                            if (!MyValidation.isName(name))
                                throw new Exception();
                            cont = false;
                        } catch (Exception e) {
                            System.out.println("Product name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
                            cont = true;
                        }
                    } while (cont);
                    
                    // Enter Price
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter product Price: ");
                            sc = new Scanner(System.in);
                            price = sc.nextLong();
                            if (price < 0)
                                throw new Exception();
                            cont = false;
                        } catch (Exception e) {
                            System.out.println("Product price must be a positive number!");
                            cont = true;
                        }
                    } while (cont);
                    
                    // Enter Quantity
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter product Quantity: ");
                            sc = new Scanner(System.in);
                            quantity = sc.nextInt();
                            if (quantity < 0)
                                throw new Exception();
                            cont = false;
                        } catch (Exception e) {
                            System.out.println("Product quantity must be a positive integer!");
                            cont = true;
                        }
                    } while (cont);
                    
                    // Enter CateID
                    cont = true;
                    do {
                        try {
                            System.out.print("\tEnter product Category ID: ");
                            sc = new Scanner(System.in);
                            cateID = sc.nextLine();
                            if (!MyValidation.isID(cateID))
                                throw new Exception("Category ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
                            if (cateList.searchCategory(cateID) == null)
                                throw new Exception("Category ID " + cateID + " doesn't exist! Please try again with another ID...");
                            cont = false;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            cont = true;
                        }
                    } while (cont);
                    
                    // Create Product
                    try {
                        Product nPro = new Product(id, name, price, quantity, cateID);
                        if (proList.addProduct(nPro)) {
                            System.out.println("Added Product successfully!");
                            FileDAO.saveProduct(proFile, proList);
                        }
                        else
                            throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Failed to add! Please try again...");
                    }
                    MyValidation.getEnter("Press Enter to go back to the Main Menu...");
                    break;
                case 4:
                    // Update product
                    System.out.println("-----------------");
                    System.out.println("Update Product...");
                    if (proList.isEmpty()) {
                        System.out.println("Product List is empty! Try to add some Products to operate...");
                        MyValidation.getEnter("Press Enter to get back to the Main Menu...");
                    } else {
                        // Enter ID
                        id = "";
                        cont = true;
                        do {
                            try {
                                System.out.print("\tEnter product ID to update: ");
                                sc = new Scanner(System.in);
                                id = sc.nextLine();
                                if (!MyValidation.isID(id))
                                    throw new Exception();
                                cont = false;
                            } catch (Exception e) {
                                System.out.println("Product ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
                                cont = true;
                            }
                        } while (cont);
                        Product uPro = proList.searchProduct(id);
                        if (uPro == null) {
                            System.out.println("No such a Product to update!");
                            MyValidation.getEnter("Press Enter to go back to the Main Menu...");
                        }
                        else {
                            System.out.println("Product found! What do you want to do?");
                            int cChoice = 0;
                            do {                            
                                cChoice = subPro.getUserChoice();
                                switch (cChoice) {
                                    case 1:
                                        // Update Info
                                        name = ""; price = 0; quantity = 0; cateID = "";
                                        System.out.println("\n\tUpdate product Information...");
                                        System.out.println("Enter new information or just blank to stay unchanged.");
                                        System.out.println("\tProduct ID: " + uPro.getId());
                                        
                                        // Name
                                        System.out.println("\tOld Product name: " + uPro.getName());
                                        cont = true;
                                        do {
                                            try {
                                                System.out.print("\tNew product Name: ");
                                                sc = new Scanner(System.in);
                                                name = sc.nextLine();
                                                if (MyValidation.isEmptyString(name))
                                                    name = uPro.getName();
                                                else if (!MyValidation.isName(name))
                                                    throw new Exception();
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println("Product name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Price
                                        System.out.println("\tOld Product price: " + uPro.getPrice());
                                        cont = true;
                                        do {
                                            try {
                                                System.out.print("\tNew product Price: ");
                                                sc = new Scanner(System.in);
                                                String tmpPrice = sc.nextLine();
                                                if (MyValidation.isEmptyString(tmpPrice))
                                                    price = uPro.getPrice();
                                                else {
                                                    price = Double.parseDouble(tmpPrice);
                                                    if (price < 0)
                                                        throw new Exception();
                                                }
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println("Product price must be a positive number!");
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Enter Quantity
                                        System.out.println("\tOld Product Quantity: " + uPro.getQuantity());
                                        cont = true;
                                        do {
                                            try {
                                                System.out.print("\tNew product Quantity: ");
                                                sc = new Scanner(System.in);
                                                String tmpQuan = sc.nextLine();
                                                if (MyValidation.isEmptyString(tmpQuan))
                                                    quantity = uPro.getQuantity();
                                                else {
                                                    quantity = Integer.parseInt(tmpQuan);
                                                    if (quantity < 0)
                                                        throw new Exception();
                                                }
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println("Product quantity must be a positive integer!");
                                                cont = true;
                                            }
                                        } while (cont);

                                        // Enter CateID
                                        System.out.println("\tOld Category ID: " + uPro.getCategoryID());
                                        cont = true;
                                        do {
                                            try {
                                                System.out.print("\tNew product Category ID: ");
                                                sc = new Scanner(System.in);
                                                cateID = sc.nextLine();
                                                if (MyValidation.isEmptyString(cateID))
                                                    cateID = uPro.getCategoryID();
                                                else if (!MyValidation.isID(cateID))
                                                    throw new Exception("Category ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
                                                if (cateList.searchCategory(cateID) == null)
                                                    throw new Exception("Category ID " + cateID + " doesn't exist! Please try again with another ID...");
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                cont = true;
                                            }
                                        } while (cont);
                                        
                                        if (proList.updateProduct(uPro, name, price, quantity, cateID)) {
                                            FileDAO.saveProduct(proFile, proList);
                                            System.out.println("Updated product successfully!");
                                        }
                                        else
                                            System.out.println("Failed to update! Please try again...");
                                        MyValidation.getEnter("Press Enter to go back to the Update menu...");
                                        cont = true;
                                        break;
                                    case 2:
                                        // Delete
                                        boolean iCont = MyValidation.isContinue("Do you really want to delete this Product "
                                                                    + "(ID: " + uPro.getId() + ") (y/n)? ");
                                        if (iCont) {
                                            // Delete
                                            try {
                                                if (proList.deleteProduct(uPro, orderList) != null) {
                                                    FileDAO.saveProduct(proFile, proList);
                                                    System.out.println("Deleted successfully!");
                                                    MyValidation.getEnter("Press Enter to get back to the Main Menu...");
                                                    cont = false;
                                                }
                                                else
                                                    throw new Exception();
                                            } catch (Exception e) {
                                                System.out.println("Failed to delete! Please try again...");
                                                MyValidation.getEnter("Press Enter to get back to the Update menu...");
                                                cont = true;
                                            }
                                        } else {
                                            MyValidation.getEnter("Press Enter to get back to the Update menu...");
                                            cont = true;
                                        }
                                        break;
                                    case 3:
                                        cont = false;
                                        break;
                                }
                            } while (cont);
                        }
                    }
                    break; // DONE
                case 5:
                    // Order product
                    System.out.println("-----------------");
                    System.out.println("Order Product...");
                    if (proList.isEmpty()) {
                        System.out.println("Product List is empty! Try to add some Products to operate...");
                        MyValidation.getEnter("Press Enter to get back to the Main Menu...");
                    } else {
                        int cChoice = 0;
                        do {                            
                            cChoice = subOrder.getUserChoice();
                            cont = true;
                            switch (cChoice) {
                                case 1:
                                    // Display
                                    System.out.println("\tList of Products");
                                    proList.displayAll();
                                    MyValidation.getEnter("Press Enter to get back to the Order menu...");
                                    cont = true;
                                    break;
                                case 2:
                                    // Order
                                    OrderDetail oDetail = new OrderDetail();
                                    System.out.println("\tOrder...");
                                    boolean oCont = true;
                                    do {
                                        System.out.println("\t===================");
                                        System.out.println("\tList of Products");
                                        ProductList disList = proList.displayAll();
                                        System.out.println("\t===================");

                                        // Enter Product
                                        int noPro = -1;
                                        int sumPro = disList.size();
                                        cont = true;
                                        do {                                        
                                            System.out.print("Enter Product no. you want to order: ");
                                            sc = new Scanner(System.in);
                                            try {
                                                noPro = sc.nextInt();
                                                if (noPro > sumPro)
                                                    throw new Exception();
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println("Please enter Product no. between 1 and " + sumPro + "!");
                                                cont = true;
                                            }
                                        } while (cont);

                                        Product oPro = disList.get(noPro - 1);
                                        System.out.println("\tYou selected: " + oPro.getName());

                                        // Enter Quantity
                                        int noQuan = -1;
                                        
                                        cont = true;
                                        do {                                        
                                            System.out.print("\tPlease enter Quantity of \"" + oPro.getName() + "\" you want to order: ");
                                            sc = new Scanner(System.in);
                                            try {
                                                noQuan = sc.nextInt();
                                                if (noQuan < 0 || noQuan > oPro.getQuantity())
                                                    throw new Exception();
                                                cont = false;
                                            } catch (Exception e) {
                                                System.out.println("Please enter Quantity between 0 and " + oPro.getQuantity());
                                                cont = true;
                                            }
                                        } while (cont);
                                        try {
                                            if (noQuan > 0)
                                                if (oDetail.addOrderDetail(new Order(oPro.getName(), oPro.getPrice(), noQuan)))
                                                    // Order successfully
                                                {
                                                    oPro.setQuantity(oPro.getQuantity() - noQuan);
                                                    if (MyValidation.isContinue("Do you want to order now (y/n)?")) {
                                                        System.out.println("");
                                                        System.out.println("\tYour order: ");
                                                        oDetail.displayAll();
                                                        
                                                        cont = true;
                                                        String cusName = "";
                                                        do {                                                            
                                                            System.out.print("Enter your name to process order: ");
                                                            // TODO Code
                                                            sc = new Scanner(System.in);
                                                            try {
                                                                cusName = sc.nextLine();
                                                                if (!MyValidation.isCustomerName(cusName))
                                                                    throw new Exception();
                                                                cont = false;
                                                            } catch (Exception e) {
                                                                System.out.println("Please enter your name between 3 - 50 characters from a-z, A-Z and spaces!");
                                                                cont = true;
                                                            }
                                                        } while (cont);
                                                        
                                                        // Add Order into Order List
                                                        // Random name

                                                        String randomString = MyValidation.randomString(10);
                                                        cusName += randomString;
                                                        boolean check = orderList.addOrder(cusName, oDetail);
                                                        if (check) {
                                                            FileDAO.saveProduct(proFile, proList);
                                                            System.out.println("Ordered successfully!");
                                                            MyValidation.getEnter("Press Enter to get back to the Main Menu...");
                                                            oCont = false;
                                                        }
                                                        else 
                                                            throw new Exception();
                                                    } else
                                                        oCont = true;
                                                }
                                                else 
                                                    // Order failed
                                                    throw new Exception();
                                        } catch (Exception e) {
                                            System.out.println("Failed to order! Please try again...");
                                            MyValidation.getEnter("Press Enter to get back to the Order menu...");
                                            oCont = true;
                                        }
                                    } while (oCont);
                                    break;
                                case 3:
                                    cont = false;
                                    break;
                            }
                        } while (cont);
                    }

                    break;
                case 6:
                    // Order list
                    if (orderList.isEmpty())
                        System.out.println("Order List is empty!");
                    else {
                        System.out.println("-----------------");
                        System.out.println("Order Report...");
                        orderList.displayAll();
                    }
                    break;
                case 7:
                    // Inventory report
                    if (proList.isEmpty())
                        System.out.println("Product List is empty!");
                    else {
                        System.out.println("-----------------");
                        System.out.println("Inventory Report...");
                        System.out.println("");
                        System.out.printf("%-5s\t%-35s\t%-10s\t%-10s\n", "No.", "Product name", "Price", "Quantity");
                        proList.displayInventory();
                    }
                    break;
                case 8:
                    break;
            }
            
        } while (choice != 8);
    }
}
