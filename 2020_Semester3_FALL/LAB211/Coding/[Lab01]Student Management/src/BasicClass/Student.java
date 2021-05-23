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
public class Student {
    private String id;
    private String FName;
    private String LName;
    private String gender;
    private DOB dob;
    private String email;
    private String phone;

    public Student() {
        id = FName = LName = gender = email = phone = "";
        dob = null;
    }

    public Student(String id, String FName, String LName, String gender, DOB dob, String email, String phone) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (!MyValidation.isEmptyString(id))
            this.id = id;
        else
            throw new Exception("Empty ID!");
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) throws Exception {
        if (!MyValidation.isEmptyString(FName))
            this.FName = FName;
        else
            throw new Exception("Empty First name!");
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) throws Exception {
        if (!MyValidation.isEmptyString(LName))
            this.LName = LName;
        else
            throw new Exception("Empty Last name!");
    }

    public String getGender() {
        if (gender.equalsIgnoreCase("m"))
            return "male";
        else if (gender.equalsIgnoreCase("f"))
            return "female";
        return "";
    }

    public void setGender(String gender) throws Exception {
        if (MyValidation.isGender(gender))
            this.gender = gender;
        else
            throw new Exception("Invalid Gender!");
    }

    public String getDOB() {
        return dob.toString();
    }

    public void setDOB(DOB dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (MyValidation.isEmail(email))
            this.email = email;
        else 
            throw new Exception("Invalid Email!");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if (MyValidation.isPhone(phone))
            this.phone = phone;
        else
            throw new Exception("Invalid Phone number!");
    }
}
