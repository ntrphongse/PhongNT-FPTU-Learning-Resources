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
public class MySortedLL {
    LinkedList_Element head; // beginning of the list
    LinkedList_Element tail; // end of the list
    
    public MySortedLL() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Determine the ceiling of value x in the list
     * Complexity: O(n/2)
     * @param x
     * @return the LinkedList_Element that is the ceiling of x
     */
    
    // x = 7  List: 1 2 3 4 5 8 9 --> return reference of 8
    public LinkedList_Element ceiling(Comparable x) {
        LinkedList_Element t = head;
        while (t != null && t.data.compareTo(x) < 0) // data < x
            t = t.next;
        return t;
    }
    
    /**
     * Search for the value of x in the list
     * Complexity: O(n/2)
     * @param x
     * @return the LinkedList_Element that is found
     */
    public LinkedList_Element search(Comparable x) {
        LinkedList_Element result = ceiling(x);
        if (result == null)
            return null;
        return (result.data.compareTo(x) == 0) ? result : null;
    }
    
    /**
     * Add data x to the sorted linked list
     * Complexity: O(n/2)
     * @param x
     * @return the LinkedList_Element to be added
     */
    public LinkedList_Element add(Comparable x) {
        LinkedList_Element newEle = new LinkedList_Element(x);
        LinkedList_Element after = ceiling(x); // O(n/2)
        
        if (head == null)
            head = tail = newEle;
        else if (after == null) {  // addLast
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        }
        else if (after == head) { // addFirst
            newEle.next = head; // newEle will be head
            newEle.previous = null;
            head.previous = newEle; // head is now after newEle
            head = newEle; // newEle is head now
        }
        else {  // ORDER: before <-> newEle <-> after
            LinkedList_Element before = after.previous;
            newEle.next = after;
            newEle.previous = before;
            after.previous = newEle;
            before.next = newEle;
        }
        return newEle;
    }
    
    public void add(Comparable... group) {
        for (Comparable comparable : group) {
            add(comparable);
        }
    }
    
    // Remove a specific valid reference --> O(1)
    private LinkedList_Element remove (LinkedList_Element remRef) {
        if (remRef == head && head == tail) {
            head = tail = null;
            return remRef;
        }
        
        LinkedList_Element before = remRef.previous;
        LinkedList_Element after = remRef.next;
        
        if (remRef == head) { // Remove first
            after.previous = null;
            head = after;
        }
        else if (remRef == tail) { // Remove last
            before.next = null;
            tail = before;
        }
        else {
            before.next = after;
            after.previous = before;
        }
        return remRef;
    }
    
    /**
     * Remove a specific data in the list
     * Complexity: O(n/2)
     * @param x
     * @return the removed element
     */
    public LinkedList_Element remove (Comparable x) {
        LinkedList_Element remRef = search(x); // O(n/2)
        if (remRef != null)
            remove(remRef);
        return remRef;
    }
    
    private class Traverser implements MyIterator<Comparable> {
        // curRef -> head -> ... -> tail
        LinkedList_Element curRef;
        public Traverser() {
            curRef = new LinkedList_Element(null);
            curRef.next = head;
        }

        @Override
        public boolean hasNext() {
            return (curRef.next != null);
        }

        @Override
        public Comparable next() {
            curRef = curRef.next;
            return curRef.data;
        }
    }
    
    public MyIterator iterator() {
        if (head == null)
            return null;
        return new Traverser();
    }
}
