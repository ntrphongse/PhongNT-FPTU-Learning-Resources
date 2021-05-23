/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class RecurDemo {
    // Computing n!
    public static double factorial (int n) {
        if (n < 2)
            return 1;
        return n*factorial(n-1);
    }
    
    public static double fibo(int n) {
        if (n < 3)
            return 1;
        return fibo(n-1) + fibo(n-2);
    }
    
    public static double ap(int n, double a, double r) {
        if (n == 1)
            return a;
        return ap(n-1, a, r) + r;
    }
    
    // Cấp số nhân
    // TODO Code
    public static double gp(int n, double a, double q) {
        if (n == 1)
            return a;
        return gp(n-1, a, q) * q;
    }
    
    public static int sum(int a[], int n) {
        // TODO Code
        if (n == 0)
            return 0;
        return sum(a, n-1) + a[n-1];
    }
    
    public static int max(int a[], int n) {
        if (n == 1)
            return a[0];
        return (max(a, n - 1) > a[n-1]) ? max(a, n-1) : a[n-1];
    }
    
    public static int min(int a[], int n) {
        if (n == 1)
            return a[0];
        return (min(a, n - 1) < a[n-1]) ? min(a, n-1) : a[n-1];
    }
    
    public static String convert(int n, int base) {
        if (n == 0)
            return "0";
        return convert(n/base, base) + Character.forDigit(n%base, base);
    }
    
    public static void main(String[] args) {
        System.out.println("Binary: " + convert(266, 2).replaceFirst("0", ""));
        System.out.println("Decimal: " + convert(266, 10).replaceFirst("0", ""));
        System.out.println("Octal: " + convert(266, 8).replaceFirst("0", ""));
        System.out.println("Hexadecimal: " + convert(266, 16).replaceFirst("0", ""));
    }
}
