
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
public class Student implements Comparable<Student>{
    String ID = "";
    String name = "";
    int mark = 0;
    Scanner sc = new Scanner (System.in);

    public Student(String ID) {
        this.ID = ID;
    }
    public Student(String ID, String name, int mark) {
        this.ID = ID;
        this.name = name;
        this.mark = mark;
    }
    
    @Override
    public int compareTo(Student o) {
        return ID.compareTo(o.ID);
    }

    @Override
    public String toString() {
        return ID + ", " + name + ", " + mark;
    }
    
    
    
}
