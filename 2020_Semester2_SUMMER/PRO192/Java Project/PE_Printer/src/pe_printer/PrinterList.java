
package pe_printer;

import java.util.ArrayList;

public class PrinterList {
    ArrayList<Printer> list;
    
    public PrinterList()
    {
        list = new ArrayList<>();
    }
    
    public boolean addPrinter(Printer p)
    {
        if (checkModel(p.getModelNumber()))
            return false;
        else
            return list.add(p);
    }
    
    public boolean checkModel(String ModelNumber)
    {
        if (list.isEmpty())
            return false;
        else
            for (Printer printer : list) {
                if (printer.getModelNumber().equals(ModelNumber))
                    return true;
            }
        return false;
    }
    
    public boolean updateModel(String ModelNumber, Printer p)
    {
        if (!checkModel(ModelNumber))
            return false;
        else
        {
            for (Printer printer : list) {
                if (printer.getModelNumber().equals(ModelNumber))
                {
                    printer.setType(p.getType());
                    printer.setIsColor(p.isColor);
                    printer.setPrice(p.getPrice());
                    return true;
                }
            }
            return false;
        }
    }
    
}
