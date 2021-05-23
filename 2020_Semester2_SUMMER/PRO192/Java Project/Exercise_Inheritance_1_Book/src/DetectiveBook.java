/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class DetectiveBook extends Book {
    int price;
    int YearOfPublication;

    public DetectiveBook() {
        price = 0;
        YearOfPublication = 0;
    }
    
    public DetectiveBook(int code, String title, int price, int YearOfPublication) 
    {
        super(code, title);
        this.price = price;
        this.YearOfPublication = YearOfPublication;
    }

    public int getPrice() 
    {
        return price;
    }

    public int getYearOfPublication() {
        return YearOfPublication;
    }

    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
    }

    public void setYearOfPublication(int YearOfPublication) {
        if (YearOfPublication > 0)
            this.YearOfPublication = YearOfPublication;
    }
    
    void outputDetectiveBook()
    {
        output();
        System.out.println("Price: " + price);
        System.out.println("Year of publication: " + YearOfPublication);
    }
    
}
