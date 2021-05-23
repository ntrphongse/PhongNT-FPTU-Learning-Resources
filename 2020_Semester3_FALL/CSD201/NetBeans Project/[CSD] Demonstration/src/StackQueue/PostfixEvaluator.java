/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackQueue;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class PostfixEvaluator {
    public static boolean isOperator(String S) {
        return (S.equals("+") || S.equals("-") || S.equals("*") || S.equals("/"));
    }
    
    public static double evaluate(String op, double n1, double n2) {
        if (op.equals("+"))
            return n1 + n2;
        if (op.equals("-"))
            return n1 - n2;
        if (op.equals("*"))
            return n1*n2;
        if (op.equals("/")) {
            if (n2 == 0)
                throw new RuntimeException("Divide by 0!");
            return n1/n2;
        }
        throw new RuntimeException("Operator is not supported!");
    }
    
    public static double evaluate(String exp) {
        double result = 0;
        
        StringTokenizer stk = new StringTokenizer(exp, "() ");
        Stack <Double> stack = new Stack();
        double n1, n2;
        while (stk.hasMoreElements()) {
            String part = stk.nextToken();
            if (!isOperator(part))
                stack.push(Double.parseDouble(part));
            else {
                n1 = stack.pop();
                n2 = stack.pop();
                result = evaluate(part, n1, n2);
                stack.push(result);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String exp = "((3)(4)*(5)(6)* +(3)*";
        System.out.println(evaluate(exp));
    }
}
