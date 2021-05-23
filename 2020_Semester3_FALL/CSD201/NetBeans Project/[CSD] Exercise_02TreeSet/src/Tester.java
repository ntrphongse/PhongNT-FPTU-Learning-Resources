/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Tester {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Student st = new Student("SE009", "Nam", 4);
        list.add(st);
        st = new Student("SE001", "Phuc", 7);
        list.add(st);
        st = new Student("SE006", "Vinh", 8);
        list.add(st);
        st = new Student("SE002", "Truong", 9);
        list.add(st);
        st = new Student("SE005", "Dat", 2);
        list.add(st);
        
        list.output();
        String ID = "SE003";
        st = list.search(ID);
        if (st == null)
            System.out.println("Not found!");
        else
            System.out.println("Found!");
    }
}
