
package pe_printer;


public class Printer {
    String ModelNumber;
    String type;
    boolean isColor;
    double Price;

    public Printer() {
    }

    public Printer(String ModelNumber, String type, boolean isColor, double Price) {
        this.ModelNumber = ModelNumber;
        this.type = type;
        this.isColor = isColor;
        this.Price = Price;
    }

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String ModelNumber) {
        this.ModelNumber = ModelNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsColor() {
        return isColor;
    }

    public void setIsColor(boolean isColor) {
        this.isColor = isColor;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
}
