/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListPkg;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1,2,3,4,5,6,7,8,9,10);
        
        // Test Iterator
        MyIterator iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println();
        
        // Test search
        LinkedList_Element p = list.search(5);
        if (p != null)
            System.out.println("5 existed.");
        else
            System.out.println("5 DOES NOT existed!");
        
        // Test addBefore & addAfter
        list.addBefore(new LinkedList_Element(55), p);
        list.addAfter(new LinkedList_Element(555), p);
        iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println("");
        
        // Test remove
        list.remove(5);
        iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println("");
        
        // Test addLast
        list.addLast(11, 12, 13, 14);
        iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println("");
        
        // Test removeFirst && removeLast
        list.removeFirst();
        list.removeLast();
        iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println("");
    }
}
