/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgBasic;
import static MyLib.MyValidation.checkCode;

/**
 *
 * @author Hp
 */
public class Book {
    protected String Code;
    protected String Title;

    public Book() {
        Code = "";
        Title = "";
    }

    public Book(String Code, String Title) {
        this.Code = Code;
        this.Title = Title;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        if (checkCode(Code))
            this.Code = Code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString() {
        return "Code: " + getCode() + "\nTitle: " + getTitle();
    }
    
    
}
