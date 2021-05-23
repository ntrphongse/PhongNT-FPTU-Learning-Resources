/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Comparator;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Employee implements Comparable<Employee>{
    String ID = "", name = "";
    int salary = 0;
    
    public Employee(String id, String n, int s) {
        ID = id;
        name = n;
        salary = s;
    }

    @Override
    public String toString() {
        return ID + ", " + name + ", " + salary;
    }
    
    @Override
    public int compareTo(Employee o) {
        return ID.compareTo(o.ID);
    }
    
    public static Comparator compartObj = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Employee emp1 = (Employee) o1;
            Employee emp2 = (Employee) o2;
            int d = emp1.salary - emp2.salary;
            if (d > 0)
                return -1; // lower salary => move upper
            if (d == 0)
                return emp1.ID.compareTo(emp2.ID);
            return 1;
        }
    };
    
}
