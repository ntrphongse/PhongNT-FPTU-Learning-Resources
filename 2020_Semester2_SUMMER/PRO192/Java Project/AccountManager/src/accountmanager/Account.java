/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanager;

import Validation.MyLib;

/**
 *
 * @author Hp
 */
public class Account {
    // instance variables
    int balance; // So du tai khoản
    String name;
    
    static float rate; // = 0.1f;
    
    // CLASS CONSTRUCTOR - Hàm để khởi tạo các biến STATIC
    // Được tự động run lúc đầu chạy chương trình và CHỈ RUN 1 LẦN DUY NHẤT
    static {
        rate = 0.1f;
        System.out.println("Em yeu co!");
    }

    // instance constructors
    public Account() {
        balance = 0;
        name = "";
    }

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (MyLib.isValidNumber(balance))
            this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Regular Expression
        if (MyLib.isValidString(name, "[a-zA-Z]+"))
            this.name = name;
    }
    
    void output()
    {
        System.out.println("Balance: " + balance);
        System.out.println("Name: " + name);
        System.out.println("Rate: " + rate);
    }
    
    // CLASS METHOD
    public static void changeRate(float newRate)
    {
        if (newRate >= 0 && newRate <= 1)
            rate = newRate;
    }
    
}
