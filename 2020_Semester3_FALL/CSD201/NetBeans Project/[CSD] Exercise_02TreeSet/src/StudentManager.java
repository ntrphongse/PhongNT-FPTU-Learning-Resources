
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StudentManager {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        // Menu
        Menu menu = new Menu();
        menu.add("Add new Student");
        menu.add("Search student based on ID");
        menu.add("Delete student");
        menu.add("Output");
        menu.add("Quit");
        int choice;
        do {
            choice = menu.getUserChoice();
            Scanner sc = new Scanner(System.in);
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    sc = new Scanner(System.in);
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    System.out.print("Enter Mark: ");
                    sc = new Scanner(System.in);
                    int mark = sc.nextInt();
                    Student st = new Student(id, name, mark);
                    list.add(st);
                    System.out.println("Added successfully!");
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    sc = new Scanner(System.in);
                    id = sc.nextLine();
                    Student sStu = list.search(id);
                    if (sStu != null)
                        System.out.println("Found " + sStu);
                    else
                        System.out.println("Student " + id + " does not exist!");
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    sc = new Scanner(System.in);
                    id = sc.nextLine();
                    if ((sStu = list.search(id)) != null) {
                        if (list.remove(sStu))
                            System.out.println("Remove successfully!");
                    }
                    else
                        System.out.println("Student " + id + " does not exist!");
                    break;
                case 4:
                    list.output();
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
