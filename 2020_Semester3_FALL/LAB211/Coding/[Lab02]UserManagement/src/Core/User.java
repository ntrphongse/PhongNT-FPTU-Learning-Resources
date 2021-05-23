/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Validation.MyValidation;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class User {
    private String username;
    private String FName;
    private String LName;
    private String password;
    private String phone;
    private String email;

    public User(String username, String FName, String LName, String password, String phone, String email) throws Exception {
        if (!MyValidation.isUsername(username))
            throw new Exception("Invalid username! Please enter username at least 5 characters but no spaces!");
        if (!MyValidation.isName(FName))
            throw new Exception("Invalid First name! Please enter First name from 2 to 35 characters!");
        if (!MyValidation.isName(LName))
            throw new Exception("Invalid Last name! Please enter Last name from 2 to 35 characters!");
        if (!MyValidation.isPhone(phone))
            throw new Exception("Invalid Phone number! Please enter Phone number with 10 characters of numbers from 0 to 9!");
        if (!MyValidation.isEmail(email))
            throw new Exception("Invalid Email! Please enter a valid Email!");
        this.username = username;
        this.FName = FName;
        this.LName = LName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) throws Exception {
        if (!MyValidation.isName(FName))
            throw new Exception("Invalid First name! Please enter First name from 2 to 35 characters!");
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) throws Exception {
        if (!MyValidation.isName(LName))
            throw new Exception("Invalid Last name! Please enter Last name from 2 to 35 characters!");
        this.LName = LName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if (!MyValidation.isPhone(phone))
            throw new Exception("Invalid Phone number! Please enter Phone number with 10 characters of numbers from 0 to 9!");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (!MyValidation.isEmail(email))
            throw new Exception("Invalid Email! Please enter a valid Email!");
        this.email = email;
    }

    @Override
    public String toString() {
        return username + "," + FName + "," + LName + "," + password + "," + phone + "," + email;
    }
}
