
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
        Product EP = new ElectricProduct();
        Product CP = new CeramicProduct();
        Product FP = new FoodProduct();
        int code;
        String name;
        String make;
        int price;
        
        do
        {
            System.out.println("Menu to choose");
            System.out.println("\t1 - Create an Electric product");
            System.out.println("\t2 - Create a Ceramic product");
            System.out.println("\t3 - Create a Food product");
            System.out.println("\t4 - Display objects were created");
            System.out.println("\t5 - Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1:
                    System.out.println("------------------");
                    System.out.println("Create an Electric product");
                    
                    do
                    {
                        System.out.println("Enter the code > 0: ");
                        sc = new Scanner(System.in);
                        code = sc.nextInt();
                    } while (code < 0);
                    EP.setCode(code);
                    
                    do
                    {
                        System.out.println("Enter the name: ");
                        sc = new Scanner(System.in);
                        name = sc.nextLine();
                    } while (name.equals(""));
                    EP.setName(name);
                    
                    do
                    {
                        System.out.println("Enter the make: ");
                        sc = new Scanner(System.in);
                        make = sc.nextLine();
                    } while (make.equals(""));
                    EP.setMake(make);
                    
                    do
                    {
                        System.out.println("Enter the price > 0: ");
                        sc = new Scanner(System.in);
                        price = sc.nextInt();
                    } while (price < 0);
                    EP.setPrice(price);
                    
                    String guaranty;
                    do
                    {
                        System.out.println("Enter the guaranty: ");
                        sc = new Scanner(System.in);
                        guaranty = sc.nextLine();
                    } while (guaranty.equals(""));
                    ((ElectricProduct)EP).setGuaranty(guaranty);
                    
                    int voltage;
                    do
                    {
                        System.out.println("Enter the voltage > 0: ");
                        sc = new Scanner(System.in);
                        voltage = sc.nextInt();
                    } while (voltage < 0);
                    ((ElectricProduct)EP).setVoltage(voltage);
                    
                    float power;
                    do
                    {
                        System.out.println("Enter the power > 0: ");
                        sc = new Scanner(System.in);
                        power = sc.nextFloat();
                    } while (power < 0);
                    ((ElectricProduct)EP).setPower(power);
                    
                    System.out.println("Create successfully!");
                    
                    break;
                    
                case 2:
                    System.out.println("------------------");
                    System.out.println("Create an Ceramic product");
                    
                    do
                    {
                        System.out.println("Enter the code > 0: ");
                        sc = new Scanner(System.in);
                        code = sc.nextInt();
                    } while (code < 0);
                    CP.setCode(code);
                    
                    do
                    {
                        System.out.println("Enter the name: ");
                        sc = new Scanner(System.in);
                        name = sc.nextLine();
                    } while (name.equals(""));
                    CP.setName(name);
                    
                    do
                    {
                        System.out.println("Enter the make: ");
                        sc = new Scanner(System.in);
                        make = sc.nextLine();
                    } while (make.equals(""));
                    CP.setMake(make);
                    
                    do
                    {
                        System.out.println("Enter the price > 0: ");
                        sc = new Scanner(System.in);
                        price = sc.nextInt();
                    } while (price < 0);
                    CP.setPrice(price);
                    
                    String type;
                    do
                    {
                        System.out.println("Enter the type: ");
                        sc = new Scanner(System.in);
                        type = sc.nextLine();
                    } while (type.equals(""));
                    ((CeramicProduct)CP).setType(type);
                    
                    System.out.println("Create successfully!");
                    
                    break;
                case 3:
                    System.out.println("------------------");
                    System.out.println("Create an Food product");
                    
                    do
                    {
                        System.out.println("Enter the code > 0: ");
                        sc = new Scanner(System.in);
                        code = sc.nextInt();
                    } while (code < 0);
                    FP.setCode(code);
                    
                    do
                    {
                        System.out.println("Enter the name: ");
                        sc = new Scanner(System.in);
                        name = sc.nextLine();
                    } while (name.equals(""));
                    FP.setName(name);
                    
                    do
                    {
                        System.out.println("Enter the make: ");
                        sc = new Scanner(System.in);
                        make = sc.nextLine();
                    } while (make.equals(""));
                    FP.setMake(make);
                    
                    do
                    {
                        System.out.println("Enter the price > 0: ");
                        sc = new Scanner(System.in);
                        price = sc.nextInt();
                    } while (price < 0);
                    FP.setPrice(price);
                    
                    String date;
                    do
                    {
                        System.out.println("Enter the date: ");
                        sc = new Scanner(System.in);
                        date = sc.nextLine();
                    } while (date.equals(""));
                    ((FoodProduct)FP).setDate(date);
                    
                    String expiredDate;
                    do
                    {
                        System.out.println("Enter the expired date: ");
                        sc = new Scanner(System.in);
                        expiredDate = sc.nextLine();
                    } while (expiredDate.equals(""));
                    ((FoodProduct)FP).setExpiredDate(expiredDate);
                    
                    System.out.println("Create successfully!");
                    
                    break;
                case 4:
                    System.out.println("------------------");
                    System.out.println("Created objects");
                    if (EP.code != 0)
                    {
                        System.out.println("\tElectric Product:");
                        System.out.println("Code: " + EP.getCode());
                        System.out.println("Name: " + EP.getName());
                        System.out.println("Make: " + EP.getMake());
                        System.out.println("Price: " + EP.getPrice());
                        System.out.println("Guaranty: " + ((ElectricProduct)EP).getGuaranty());
                        System.out.println("Voltage: " + ((ElectricProduct)EP).getVoltage());
                        System.out.println("Power: "+ ((ElectricProduct)EP).getPower());
                    } 
                    if (CP.code != 0)
                    {
                        System.out.println("\tCeramic Product:");
                        System.out.println("Code: " + CP.getCode());
                        System.out.println("Name: " + CP.getName());
                        System.out.println("Make: " + CP.getMake());
                        System.out.println("Price: " + CP.getPrice());
                        System.out.println("Type: " + ((CeramicProduct)CP).getType());
                        
                    } 
                    if (FP.code != 0)
                    {
                        System.out.println("\tFood Product:");
                        System.out.println("Code: " + FP.getCode());
                        System.out.println("Name: " + FP.getName());
                        System.out.println("Make: " + FP.getMake());
                        System.out.println("Price: " + FP.getPrice());
                        System.out.println("Date: " + ((FoodProduct)FP).getDate());
                        System.out.println("Expired Date: " + ((FoodProduct)FP).getExpiredDate());
                    } 
                    if (EP.code == 0 && CP.code == 0 && FP.code == 0)
                        System.out.println("There is no object to display!");
                    break;
                case 5:
                    
                    break;
                default:
                    System.out.println("Error! Please enter from 1 to 5!");
            }
        } while (choice != 5);
    }
    
}
