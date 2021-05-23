/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackQueue;

import java.util.Stack;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class NumStringAdder {
    public static int add(int carry, char d1, char d2, Stack resultStk) {
        int newCarry = 0;
        int num1 = Character.getNumericValue(d1);
        int num2 = Character.getNumericValue(d2);
        int sum = carry + num1 + num2;
        if (sum >= 10) {
            newCarry = 1;
            sum -= 10;
        }
        resultStk.push(Character.forDigit(sum, 10));
        return newCarry;
    }
    
    public static String add(String num1, String num2) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for (int i = 0; i < num1.length(); i++)
            stk1.push(num1.charAt(i));
        for (int i = 0; i < num2.length(); i++) 
            stk2.push(num2.charAt(i));
           
        Stack<Character> stk3 = new Stack();
        char d1, d2;
        int carry = 0;
        while (!stk1.empty() || !stk2.empty()) {
            d1 = (!stk1.empty()) ? stk1.pop() : '0';
            d2 = (!stk2.empty()) ? stk2.pop() : '0';
            carry = add(carry, d1, d2, stk3);
        }
        
        String result = "";
        while (!stk3.empty())
            result += stk3.pop();
        return result;
    }
    public static void main(String[] args) {
        String num1 = "592";
        String num2 = "3784";
        String sumStr = add(num1, num2);
        System.out.println(sumStr);
    }
}
