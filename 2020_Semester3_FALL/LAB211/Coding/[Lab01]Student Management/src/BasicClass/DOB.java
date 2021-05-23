/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicClass;

import Validation.MyValidation;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DOB {
    int day;
    int month;
    int year;

    public DOB() {
        day = month = year = 1;
    }

    public DOB(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public DOB(String date) throws Exception {
        if (!MyValidation.isValidDate(date, "dd/MM/yyyy")) 
            throw new Exception("Invalid Date of Birth!");
        else {
            String[] arr = date.split("/");
            if (arr.length != 3)
                throw new Exception("Invalid Date of Birth!");
            else if ((Integer.parseInt(arr[2]) == 2020 && Integer.parseInt(arr[1]) >= 10) || Integer.parseInt(arr[2]) > 2020)
                throw new Exception("Invalid Date of Birth!");
            else {
                this.day = Integer.parseInt(arr[0]);
                this.month = Integer.parseInt(arr[1]);
                this.year = Integer.parseInt(arr[2]);
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    
    
    
}
