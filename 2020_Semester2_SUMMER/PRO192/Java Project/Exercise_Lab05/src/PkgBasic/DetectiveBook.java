/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgBasic;

/**
 *
 * @author Hp
 */
public class DetectiveBook extends Book {
    public int price;
    int yearofpublication;

    public DetectiveBook() {
        super();
        price = 0;
        yearofpublication = 0;
    }

    public DetectiveBook(int price, int yearofpublication, String Code, String Title) {
        super(Code, Title);
        this.price = price;
        this.yearofpublication = yearofpublication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(int yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + getYearofpublication() + " - " + getPrice() + "$";
    }
    
    
}
