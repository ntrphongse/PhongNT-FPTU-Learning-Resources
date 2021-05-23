/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Electric implements Comparable<Electric> {
    String Id;
    String Name;
    int Price;

    public Electric() {
    }

    public Electric(String Id, String Name, int Price) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public int compareTo(Electric o) {
        return ((TV)this).Brand.compareTo(((TV)o).Brand);
    }
    

}
