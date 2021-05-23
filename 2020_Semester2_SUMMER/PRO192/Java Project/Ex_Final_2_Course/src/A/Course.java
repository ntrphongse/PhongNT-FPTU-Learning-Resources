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
public class Course {
    private String Name;
    private int Hours;

    public Course() {
        Name = "";
        Hours = 0;
    }

    public Course(String Name, int Hours) {
        this.Name = Name;
        this.Hours = Hours;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) throws Exception {
        if (MyValidation.checkEmptyString(Name))
            throw new Exception("Please enter a not-empty Name!");
        this.Name = Name;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) throws Exception {
        if (!MyValidation.checkIntNumber(Hours, 1, 3))
            throw new Exception("Please enter Hours between 1 and 3!");
        this.Hours = Hours;
    }
    
    
}
