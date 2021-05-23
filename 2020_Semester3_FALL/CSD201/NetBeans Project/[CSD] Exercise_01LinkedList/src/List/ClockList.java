/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Basic.Clock;
import Validation.MyValidation;
import java.util.LinkedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ClockList extends LinkedList<Clock>{
    public LinkedList<Clock> getClockList() {
        return this;
    }
    
    public boolean addClock(Clock newClock) {
        try {
            this.add(newClock);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Clock search(String searchID) {
        for (Clock clock : this) {
            if (clock.getId().equalsIgnoreCase(searchID))
                return clock;
        }
        return null;
    }
    
    public boolean removeClock(String delID) {
        Clock sClock = search(delID);
        if (sClock == null)
            return false;
        try {
            this.remove(sClock);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean updateClock(Clock oldClock, Clock newClock) {
        try {
            String nManu = newClock.getManufacturer();
            double nPrice = newClock.getPrice();
            int nGuarant = newClock.getGuarantee();
            if (!MyValidation.isEmptyString(nManu))
                oldClock.setManufacturer(nManu);
            if (nPrice > 0)
                oldClock.setPrice(nPrice);
            if (nGuarant >= 0)
                oldClock.setGuarantee(nGuarant);
            return true;                
        } catch (Exception e) {
            return false;
        }
    }
    
    public void printClock(Clock clock) {
        System.out.printf("%-10s\t%-15s\t%-10.3f\t%-15s\n", clock.getId(), clock.getManufacturer(), clock.getPrice(), clock.getGuarantee());
    }
    
    public void clockReport() {
        System.out.printf("%-10s\t%-15s\t%-10s\t%-15s\n", "Clock ID", "Manufacturer", "Price", "No. Guarante month");
        for (Clock clock : this) {
            printClock(clock);
        }
    }
    
    public void rangeClockReport(double minPrice, double maxPrice) {
        System.out.printf("%-10s\t%-15s\t%-10s\t%-15s\n", "Clock ID", "Manufacturer", "Price", "No. Guarante month");
        for (Clock clock : this) {
            if (MyValidation.checkNumber(clock.getPrice(), minPrice, maxPrice))
                printClock(clock);
        }
    }
    
}
