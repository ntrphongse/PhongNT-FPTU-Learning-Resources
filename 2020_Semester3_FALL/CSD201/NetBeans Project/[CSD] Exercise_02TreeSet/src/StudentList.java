
import java.util.Iterator;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StudentList extends TreeSet<Student>{

    public StudentList() {
        super();
    }
    
    public Student search(String ID) {
        Student sStu = this.ceiling(new Student(ID));
        if (sStu != null && sStu.ID.equals(ID))
            return sStu;
        return null;
    }
    
    public void output() {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Student stu = (Student)it.next();
            System.out.println(stu);
        }
    }
}
