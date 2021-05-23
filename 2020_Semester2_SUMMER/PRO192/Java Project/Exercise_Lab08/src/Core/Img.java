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
public class Img extends Tag{
    String src;
    int top;
    int left;

    public Img() {
        super();
        src = "";
        top = 0;
        left = 0;
    }

    public Img(String src, int top, int left, String name, String content) {
        super(name, content);
        this.src = src;
        this.top = top;
        this.left = left;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    @Override
    public void format() {
        System.out.println("<img src='" + getSrc() + ""
                + " top = '" + getTop()+ "' "
                        + "left = '" + getLeft() + "' >");
    }
    
    
    
    
}
