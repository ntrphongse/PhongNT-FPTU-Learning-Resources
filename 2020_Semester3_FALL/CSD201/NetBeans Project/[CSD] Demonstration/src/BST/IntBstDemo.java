/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

import java.util.Scanner;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class IntBstDemo {
    static Scanner sc = new Scanner(System.in);
    static int input(String msg) {
        System.out.print("\n" + msg);
        return Integer.parseInt(sc.nextLine());
    }
    
    static void output(String msg) {
        System.out.println("\n" + msg + "\n");
    }
    
    public static void main(String[] args) {
        Menu mnu = new Menu();
        mnu.add("Add new key");
        mnu.add("Maximum value");
        mnu.add("Minimum value");
        mnu.add("Average value");
        mnu.add("Tree's height");
        mnu.add("Breadth-first output");
        mnu.add("Align output");
        mnu.add("Preorder output");
        mnu.add("Inorder-LNR output");
        mnu.add("Inorder-RNL output");
        mnu.add("Postorder output");
        mnu.add("Searching a key");
        mnu.add("Removing a key-By merging");
        mnu.add("Removing a key-By copying");
        
        IntBstTree tree = new IntBstTree();
        tree.add(32,11,57,6,18,40,80,2,8,16,22,35,50,70,90,1,5,10,15,17,34,37,45,85,3);
        int choice;
        int x;
        do {            
            choice = mnu.getUserChoice();
            switch (choice) {
                case 1:
                    x = input("Input a key: ");
                    if (tree.add(x))
                        output("Adding " + x + " successfully!");
                    else
                        output("Adding failed");
                    break;
                    
                case 2:
                    output("Max value: " + tree.getMax());
                    break;
                    
                case 3:
                    output("Min value: " + tree.getMin());
                    break;
                    
                case 4:
                    output("Avg. value: " + tree.getAverage());
                    break;
                    
                case 5:
                    output("Tree's height: " + tree.getHeight());
                    break;
                    
                case 6:
                    output("Breadth-first / level-based output: ");
                    tree.printLevelBased();
                    break;
                    
                case 7:
                    output("Tree in aligned format: ");
                    tree.printAlign();
                    break;
                    
                case 8:
                    output("Tree in preorder list: ");
                    tree.printNLR();
                    break;
                    
                case 9:
                    output("Inorder-LNR output: ");
                    tree.printLNR();
                    break;
                    
                case 10:
                    output("Inorder-RNL output: ");
                    tree.printRNL();
                    break;
                    
                case 11:
                    output("Postorder output: ");
                    tree.printPostOrder();
                    break;
                    
                case 12:
                    x = input("Input searched value: ");
                    IntBstNode node = tree.search(x);
                    if (node == null)
                        output("Not found!");
                    else
                        output("Found: " + node.key);
                    break;
                    
                case 13:
                    x = input("Input deleted key: ");
                    if (tree.deleteByMerging(x))
                        output("Deleting successfully!");
                    else
                        output("Deleting failed!");
                    break;
                    
                case 14:
                    x = input("Input deleted key: ");
                    if (tree.deleteByCopying(x))
                        output("Deleting successfully!");
                    else
                        output("Deleting failed!");
                    break;
            }
        } while (choice > 0 && choice < mnu.size());
    }
}
