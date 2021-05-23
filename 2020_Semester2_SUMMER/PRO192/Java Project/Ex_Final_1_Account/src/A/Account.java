/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import MyLib.MyValidation;

/**
 *
 * @author Hp
 */
public class Account {
    String email;
    String password;

    public Account(String email, String password) {
        if (!MyValidation.checkEmail(email) || !MyValidation.checkPassword(password))
        {
            System.out.println("Failed to create an Account!");
        }
        else
        {
            this.email = email;
            this.password = password;
        }
    }

    public Account() {
        email = "";
        password = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!MyValidation.checkEmail(email))
        {
            System.out.println("Invalid email address! Please check again!");
        }
        else
        {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!MyValidation.checkPassword(password))
        {
            System.out.println("Invalid password format! Please check again!");
        }
        else
        {
            this.password = password;
        }
    }
    
    
    
}
