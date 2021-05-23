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
public class DSWIntBstTree extends IntBstTree {
    // Rotate right Grandparent Gr, parent Par, left child Ch
    public void rotateRight(IntBstNode Gr, IntBstNode Par, IntBstNode Ch) {
        if (Par != root) {
            Ch.father = Gr;
            Gr.right = Ch;
        }
        Par.left = Ch.right;
        if (Par.left != null)
            Par.left.father = Par;
        Ch.right = Par;
        Par.father = Ch;
    }
    
    // Create right backbone - Using right rotations
    // Return number of nodes in the tree
    private int createBackbone() {
        if (root == null)
            return 0;
        int noOfNodes = 0;
        IntBstNode tmp = root, Gr, Par, Ch;
        
        while (tmp != null) {
            while (tmp.left != null) {
                Gr = tmp.father;
                Par = tmp;
                Ch = tmp.left;
                rotateRight(Gr, Par, Ch);
                if (Gr == null) {
                    root = Ch;
                    root.father = null;
                } // Update the root
                tmp = Ch;
            }
            tmp = tmp.right;
            noOfNodes++;
        }
        return noOfNodes;
    }
    
    // Rotate Left
    public void rotateLeft(IntBstNode Gr, IntBstNode Par, IntBstNode Ch) {
        if (Gr == null)
            root = Ch;
        else
            Gr.right = Ch;
        Ch.father = Gr;
        Par.right = Ch.left;
        if (Par.right != null)
            Par.right.father = Par;
        Ch.left = Par;
        Par.father = Ch;
        Ch.father = Gr;
    }
    
    private void createBalancedTree(int noOfNodes) {
        int n = noOfNodes;
        double log2nPlus1 = Math.log(n+1)/Math.log(2);
        int L = (int) (log2nPlus1);
        int m = (int) (Math.pow(2, L) - 1);
        IntBstNode Gr = null, Par = root, Ch = Par.right;
        int i;
        for (i = 0; i < n-m; i++) {
            rotateLeft(Gr, Par, Ch);
            Gr = Ch;
            Par = Gr.right;
            Ch = Par.right;
        }
        
        while (m > 1) {
            m /= 2;
            Gr = null; Par = root; Ch = Par.right;
            for (i = 0; i < m; i++) {
                if (Ch != null) {
                    rotateLeft(Gr, Par, Ch);
                    Gr = Ch;
                    Par = Gr.right;
                    if (Par != null)
                        Ch = Par.right;
                    else
                        Ch = null;
                }
            }
        }
    }
    
    public void DSW_Balance() {
        if (root != null) {
            int noOfNodes = createBackbone();
            createBalancedTree(noOfNodes);
        }
    }
}
