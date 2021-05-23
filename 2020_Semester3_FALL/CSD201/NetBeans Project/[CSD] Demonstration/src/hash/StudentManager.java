/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StudentManager {
    public static void main(String[] args) {
        final String filename = "students.txt";
        Menu menu = new Menu();
        menu.add("Add new student");
        menu.add("Search student");
        menu.add("Remove a student");
        menu.add("Update a student");
        menu.add("Print the list");
        menu.add("Save the list to file");
        menu.add("Quit");
        int choice;
        StudentList L = new StudentList();
        L.loadFromFile(filename);
        do {            
            System.out.println("\nSTUDENT MANAGER");
            choice = menu.getUserChoice();
            switch(choice) {
                case 1:
                    L.addStudent();
                    break;
                case 2:
                    L.searchStudent();
                    break;
                case 3:
                    L.removeStudent();
                    break;
                case 4:
                    L.updateStudent();
                    break;
                case 5:
                    L.print();
                    break;
                case 6:
                    L.saveToFile(filename);
                    break;
            }
        } while (choice > 0 && choice < 7);
    }
}
