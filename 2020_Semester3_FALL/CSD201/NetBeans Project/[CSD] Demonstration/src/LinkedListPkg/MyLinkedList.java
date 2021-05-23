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
public class MyLinkedList {
    LinkedList_Element head; // reference to the beginning of the list
    LinkedList_Element tail; // reference to the end of the list
    
    // Default constructor: Initialize an empty list
    public MyLinkedList() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Add a new element to the begin of the list.
     * Complexity: O(1)
     * @param newEle
     * @return LinkedList_Element as an extra utilities if needed
     */
    public LinkedList_Element addFirst(LinkedList_Element newEle) {
        // The list is empty
        if (isEmpty())
            head = tail = newEle;
        else {
            newEle.next = head; // newEle will be head
            newEle.previous = null;
            head.previous = newEle; // head is now after newEle
            head = newEle; // newEle is head now
        }
        return newEle;
    }
    
    /**
     * Add a new element to the end of the list
     * Complexity: O(1)
     * @param newEle
     * @return LinkedList_Element as an utilities if needed
     */
    public LinkedList_Element addLast(LinkedList_Element newEle) {
        // The empty if empty
        if (isEmpty())
            head = tail = newEle;
        else {
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        }
        return newEle;
    }
    
    /**
     * Add a new element (newElement) to the position after a element (p)
     * Complexity: O(1)
     * @param newEle
     * @param p
     * @return LinkedList_Element as an utilities if needed
     */
    public LinkedList_Element addAfter(LinkedList_Element newEle, LinkedList_Element p) {
        if (p == null || p == tail)
            return addLast(newEle);
        LinkedList_Element pAfter = p.next;
        newEle.next = pAfter;
        newEle.previous = p;
        pAfter.previous = newEle;
        p.next = newEle;
        return newEle;
    }
    
    /**
     * Add a new element (newElement) to the position before a element (p)
     * Complexity: O(1)
     * @param newEle
     * @param p
     * @return LinkedList_Element as an utilities if needed
     */
    public LinkedList_Element addBefore(LinkedList_Element newEle, LinkedList_Element p) {
        if (p == null || p == head)
            return addFirst(newEle);
        LinkedList_Element pBefore = p.previous;
        newEle.next = p;
        newEle.previous = pBefore;
        pBefore.next = newEle;
        p.previous = newEle;
        return newEle;
    }
    
    /**
     * Linear search data in the list
     * Complexity: O(n)
     * @param x
     * @return the LinkedList_Element found or null
     */
    public LinkedList_Element search(Comparable x) {
        LinkedList_Element t;
        for (t = head; t!= null; t = t.next)
            if (t.data.compareTo(x) == 0)
                return t;
        return null;
    }
    
    /**
     * Remove the first element of the list (the head)
     * Complexity: O(1)
     * @return the deleted LinkedList_Element
     */
    public LinkedList_Element removeFirst() {
        if (head == null)
            return null;
        LinkedList_Element result = head;
        if (head == tail)
            head = tail = null;
        else {
            LinkedList_Element newHead = head.next;
            newHead.previous = null;
            head = newHead;
        }
        return result;
    }
    
    /**
     * Remove the last element of the list (the tail)
     * Complexity: O(1)
     * @return the deleted LinkedList_Element
     */
    public LinkedList_Element removeLast() {
        if (tail == null)
            return null;
        LinkedList_Element result = tail;
        if (tail == head)
            head = tail = null;
        else {
            LinkedList_Element newTail = tail.previous;
            newTail.next = null;
            tail = newTail;
        }
        return result;
    }
    
    /**
     * Remove a valid element in the list
     * Complexity: O(1)
     * @param ele
     * @return the deleted LinkedList_Element
     */
    private LinkedList_Element remove(LinkedList_Element ele) {
        if (ele == null)
            return null;
        if (ele == head)
            return removeFirst();
        if (ele == tail)
            return removeLast();
        LinkedList_Element pBefore = ele.previous;
        LinkedList_Element pAfter = ele.next;
        pBefore.next = pAfter;
        pAfter.previous = pBefore;
        return ele;
    }
    
    /**
     * Remove an element with the value of x in the list
     * Complexity: O(n)
     * @param x
     * @return the deleted LinkedList_Element
     */
    public LinkedList_Element remove(Comparable x) {
        return remove(search(x));
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
    
    public void addFirst(Comparable... group) {
        for (Comparable data : group) {
            addFirst(new LinkedList_Element(data));
        }
    }
    
    public void addLast(Comparable... group) {
        for (Comparable data : group) {
            addLast(new LinkedList_Element(data));
        }
    }
}
