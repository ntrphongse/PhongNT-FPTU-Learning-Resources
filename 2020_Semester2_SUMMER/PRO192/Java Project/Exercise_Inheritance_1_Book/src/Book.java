/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Book {
    int code;
    String title;
    
    public Book()
    {
        code = 0;
        title = "";
    }
    
    public Book(int code, String title)
    {
        this.code = code;
        this.title = title;
    }
    
    public void setCode(int code)
    {
        if (code > 0)
            this.code = code;
    }
    
    public void setTitle(String title)
    {
        if (!(title.isEmpty()))
            this.title = title;
    }
    
    public int getCode()
    {
        return code;
    }
    
    public String getTitle()
    {
        return title.toUpperCase();
    }
    
    void output()
    {
        System.out.println("Code: " + code);
        System.out.println("Title: " + title);
    }
    
}
