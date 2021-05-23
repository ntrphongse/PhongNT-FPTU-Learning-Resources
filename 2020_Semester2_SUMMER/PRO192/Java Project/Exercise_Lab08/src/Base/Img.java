/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

/**
 *
 * @author Hp
 */
public class Img extends Tag {
    String src;
    int width;
    int height;

    public Img() {
        super();
        src = "";
        width = 0;
        height = 0;
    }

    public Img(String src, int width, int height, String name, String content) {
        super(name, content);
        this.src = src;
        this.width = width;
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void format() {
        System.out.println("<img src='" + getSrc() + ""
                + "' style = \"width: '" + getWidth()+ "px'; height: '" + getHeight() + "px'\""
                        + " alt = \"" + getContent() + "\" />");
    }
    
    
}
