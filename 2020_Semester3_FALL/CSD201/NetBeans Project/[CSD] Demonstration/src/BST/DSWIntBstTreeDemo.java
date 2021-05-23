/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DSWIntBstTreeDemo {
    public static void main(String[] args) {
        DSWIntBstTree tree = new DSWIntBstTree();
        tree.add(20,19,7,6,5,18,16,15,14,13,12,11,10,9,8,4,3,2,1);
        System.out.println("\nInitial tree:\n");
        tree.printAlign();
        tree.DSW_Balance();
        System.out.println("\nBalanced tree:\n");
        tree.printAlign();
    }
}
