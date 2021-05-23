/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgExtend;

import MyLib.MyValidation;
import static MyLib.MyValidation.checkType;
import PkgBasic.Book;

/**
 *
 * @author Hp
 */
public class ScienceBook extends Book{
    String type;

    public ScienceBook() {
        super();
        type = "";
    }

    public ScienceBook(String type, String Code, String Title) {
        super(Code, Title);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (checkType(type))
            this.type = type;
    }

    @Override
    public String toString() {
        return getTitle();
    }
    
    
}
