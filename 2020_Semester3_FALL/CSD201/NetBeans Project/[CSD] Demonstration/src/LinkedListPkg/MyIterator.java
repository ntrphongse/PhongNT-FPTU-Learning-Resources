/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListPkg;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 * @param <E>
 */
public interface MyIterator<E> {
    // Check whether any element is not visited
    public boolean hasNext();
    
    // Get data of the next element
    public E next();
}
