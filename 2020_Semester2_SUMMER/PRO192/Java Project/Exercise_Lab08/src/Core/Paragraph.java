/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Base.Tag;

/**
 *
 * @author Hp
 */
public class Paragraph extends Tag{
    String color;

    public Paragraph() {
        super();
        color = "";
    }
    
    public Paragraph(String color, String name, String content) {
        super(name, content);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void format() {
        System.out.println("<paragraph color = '" + getColor() + "'>"
                + getContent() + "</paragraph>");
    }
    
}
