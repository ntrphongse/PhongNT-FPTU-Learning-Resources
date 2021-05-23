/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogmanager;

import DTO.Dog;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class DogManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int choice;
//        DogList obj = new DogList();
        DogList2 obj = new DogList2();
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Menu to choose:");
            System.out.println("1 - Add Dog");
            System.out.println("2 - Display all");
            System.out.println("3 - Search by id");
//            System.out.println("4 - Edit by id");
//            System.out.println("5 - Delete by id");
            System.out.println("6 - Order by id");
            System.out.println("7 - Order by name");
            System.out.println("8 - Exit");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    int id;
                    String name;
                    System.out.println("Input id: ");
                    id = sc.nextInt();
                    System.out.println("Input name: ");
                    sc = new Scanner(System.in);
                    name = sc.nextLine();
                    Dog x = new Dog(id, name);
                    obj.addDog(x);
                    break;
                case 2:
                    obj.displayAll(); // Tăng dần theo tên
                    break;
                    
                case 3:
                    int sId;
                    System.out.println("Enter an id to search: ");
                    sId = sc.nextInt();
                    Dog result = obj.findDog(sId);
                    if (result == null)
                        System.out.println("Not found!");
                    else
                        System.out.println(result);
                    break;
                    
//                case 4:
//                    int eId;
//                    System.out.println("Enter ID to edit: ");
//                    eId = sc.nextInt();
//                    Dog eResult = obj.editById(eId);
//                    if (eResult == null)
//                        System.out.println("Not found to edit!");
//                    else
//                    {
//                        System.out.println("Edited successfully!!");
//                        System.out.println(eResult);
//                    }
//                    break;
//                    
//                case 5:
//                    int dId;
//                    System.out.println("Enter ID to delete: ");
//                    dId = sc.nextInt();
//                    if (obj.deleteById(dId))
//                        System.out.println("Delete successfully!");
//                    else
//                        System.out.println("Failed to delete!");
//                    break;
                case 6:
//                    obj.sortById();
                    System.out.println("Tang dan theo ten: ");
                    obj.displayAll();
                    break;
                case 7:
//                    obj.sortByName();
                    System.out.println("Giam dan theo ten: ");
                    obj.displayDecDog();
                    break;
            }
        } while (choice != 8);
    }
    
}
