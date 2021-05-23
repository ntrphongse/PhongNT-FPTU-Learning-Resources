
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
        Shape iShape = new Shape();
        String color = "red";
        boolean filled = true; String iFilled;
        int iCheck = 0;
        /*
        iCheck = 0 ==> Chưa object nào được tạo
        iCheck = 1 ==> Circle
        iCheck = 2 ==> Rectangle
        iCheck = 3 ==> Square
        */
        do
        {
            System.out.println("------------------");
            System.out.println("Menu to choose");
            System.out.println("1 - Create a Circle");
            System.out.println("2 - Create a Rectangle");
            System.out.println("3 - Create a Square");
            System.out.println("4 - Display information, perimeter and area of your created object");
            System.out.println("5 - Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1:
                    System.out.println("------------------");
                    System.out.println("Create a Circle!");

                    do 
                    {
                        System.out.println("Enter the color: ");
                        sc = new Scanner(System.in);
                        color = sc.nextLine();
                    } while (color.isEmpty());

                    do
                    {
                        System.out.println("Is the circle filled? (y/n)");
                        sc = new Scanner(System.in);
                        iFilled = sc.nextLine();
                        switch (iFilled.toLowerCase()) {
                            case "y":
                                filled = true;
                                break;
                            case "n":
                                filled = false;
                                break;
                            default:
                                System.out.println("Error!");
                                break;
                        }
                    } while (!((iFilled.equals("y")) || iFilled.equals("n"))) ;
                    
                    double radius;
                    do
                    {
                        System.out.println("Enter the radius > 0:");
                        sc = new Scanner(System.in);
                        radius = sc.nextDouble();
                    } while (radius < 0);
                    
                    iShape = new Circle(radius, color, filled);
                    iCheck = 1;
                    System.out.println("Create a Circle successfully!");
                    
                    break;
                case 2:
                    System.out.println("------------------");
                    System.out.println("Create a Rectangle!");
                    
                    do 
                    {
                        System.out.println("Enter the color: ");
                        sc = new Scanner(System.in);
                        color = sc.nextLine();
                    } while (color.isEmpty());

                    do
                    {
                        System.out.println("Is the rectangle filled? (y/n)");
                        sc = new Scanner(System.in);
                        iFilled = sc.nextLine();
                        switch (iFilled.toLowerCase()) {
                            case "y":
                                filled = true;
                                break;
                            case "n":
                                filled = false;
                                break;
                            default:
                                System.out.println("Error!");
                                break;
                        }
                    } while (!((iFilled.equals("y")) || iFilled.equals("n")));
                    
                    double width;
                    do
                    {
                        System.out.println("Enter the width > 0:");
                        sc = new Scanner(System.in);
                        width = sc.nextDouble();
                    } while (width < 0);
                    
                    double length;
                    do
                    {
                        System.out.println("Enter the length > 0:");
                        sc = new Scanner(System.in);
                        length = sc.nextDouble();
                    } while (length < 0);
                    
                    iShape = new Rectangle(width, length, color, filled);
                    iCheck = 2;
                    System.out.println("Create a Rectangle successfully!");
                    
                    break;
                case 3:
                    System.out.println("------------------");
                    System.out.println("Create a Square!");
                    
                    do 
                    {
                        System.out.println("Enter the color: ");
                        sc = new Scanner(System.in);
                        color = sc.nextLine();
                    } while (color.isEmpty());

                    do
                    {
                        System.out.println("Is the square filled? (y/n)");
                        sc = new Scanner(System.in);
                        iFilled = sc.nextLine();
                        switch (iFilled.toLowerCase()) {
                            case "y":
                                filled = true;
                                break;
                            case "n":
                                filled = false;
                                break;
                            default:
                                System.out.println("Error!");
                                break;
                        }
                    } while (!((iFilled.equals("y")) || iFilled.equals("n")));
                    
                    double side;
                    do
                    {
                        System.out.println("Enter the side > 0:");
                        sc = new Scanner(System.in);
                        side = sc.nextDouble();
                    } while (side < 0);
                    
                    iShape = new Square(side, color, filled);
                    iCheck = 3;
                    System.out.println("Create a Square successfully!");
                    
                    break;
                case 4:
                    switch (iCheck)
                    {
                        case 1:
                            System.out.println("------------------");
                            System.out.println("Circle information");
                            System.out.println("Color: " + iShape.getColor());
                            System.out.println("Is Filled?: " + iShape.isFilled());
                            System.out.println("Radius: " + ((Circle)iShape).getRadius());
                            System.out.println("Perimeter: " + ((Circle)iShape).getPerimeter());
                            System.out.println("Area: " + + ((Circle)iShape).getArea());
                            break;
                            
                        case 2:
                            System.out.println("------------------");
                            System.out.println("Rectangle information");
                            System.out.println("Color: " + iShape.getColor());
                            System.out.println("Is Filled?: " + iShape.isFilled());
                            System.out.println("Width: " + ((Rectangle)iShape).getWidth());
                            System.out.println("Length: " + ((Rectangle)iShape).getLength());
                            System.out.println("Perimeter: " + ((Rectangle)iShape).getPerimeter());
                            System.out.println("Area: " + + ((Rectangle)iShape).getArea());
                            break;
                            
                        case 3:
                            System.out.println("------------------");
                            System.out.println("Square information");
                            System.out.println("Color: " + iShape.getColor());
                            System.out.println("Is Filled?: " + iShape.isFilled());
                            System.out.println("Side: " + ((Square)iShape).getSide());
                            System.out.println("Perimeter: " + ((Square)iShape).getPerimeter());
                            System.out.println("Area: " + + ((Square)iShape).getArea());
                            break;
                            
                        case 0:
                            System.out.println("There is no created shape to display!");
                            break;
                    }
                    break;
                case 5:
                    
                    break;
                default:
                    System.out.println("Error! Please enter from 1 to 5!");
            }
        } while (choice != 5);
    }
}
