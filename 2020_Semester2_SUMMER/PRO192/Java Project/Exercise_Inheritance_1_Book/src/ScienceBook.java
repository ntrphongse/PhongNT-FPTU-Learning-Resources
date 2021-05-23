/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ScienceBook extends Book {
    String type;

    public ScienceBook(int code, String title, String type) {
        super(code, title);
        this.type = type.toLowerCase();
    }

    public String getType() {
        return type.toUpperCase();
    }

    public void setType(String type) {
        String cType = type.toLowerCase();
        if (cType.equals("physical") || cType.equals("mathematic") || cType.equals("chemistry"))
            this.type = cType;
    }
    
    void outputScienceBook()
    {
        output();
        System.out.println("Type: " + type);
    }
    
}
