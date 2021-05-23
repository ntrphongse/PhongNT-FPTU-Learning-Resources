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
public class LinkedList_Element {
    Comparable data;
    LinkedList_Element next;
    LinkedList_Element previous;
    
    // Constructor

    public LinkedList_Element(Comparable data) {
        this.data = data;
        next = previous = null;
    }
    
    // Getters, setters

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public LinkedList_Element getNext() {
        return next;
    }

    public void setNext(LinkedList_Element next) {
        this.next = next;
    }

    public LinkedList_Element getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedList_Element previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
