/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Core.Order;
import Validation.MyValidation;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderDetail extends LinkedList<Order> {
    public boolean addOrderDetail(Order o) {
        try {
            if (o == null || !MyValidation.isName(o.getProductName()) || o.getPrice() <= 0 || o.getQuantity() <= 0)
                throw new Exception();
            return this.add(o);
        } catch (Exception e) {
            return false;
        }
    }
    
    public Order searchOrderDetail(String productName) {
        Iterator<Order> it = iterator();
        while (it.hasNext()) {
            Order sOrder = it.next();
            if (sOrder.getProductName().equals(productName))
                return sOrder;
        }
        return null;
    }
    
    public boolean updateOrderDetail(Order oldOrder, String newProductName, int newQuantity) {
        try {
            if (oldOrder == null || !MyValidation.isName(newProductName) || newQuantity <= 0)
                throw new Exception();
            oldOrder.setProductName(newProductName);
            oldOrder.setQuantity(newQuantity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean updateOrderDetail(Order oldOrder, long newPrice) {
        try {
            if (oldOrder == null || newPrice <= 0)
                throw new Exception();
            oldOrder.setPrice(newPrice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Order deleteProductOrder(Order deletedOrder) {
        try {
            if (deletedOrder == null || searchOrderDetail(deletedOrder.getProductName()) == null)
                throw new Exception();
            if (this.remove(deletedOrder))
                return deletedOrder;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean deleteProductOrder(String productName) {
        try {
            if (!MyValidation.isName(productName) || searchOrderDetail(productName) == null)
                throw new Exception();
            OrderDetail deleteList = new OrderDetail();
            Iterator<Order> it = this.iterator();
            while (it.hasNext()) {
                Order o = it.next();
                if (o.getProductName().equals(productName))
                    deleteList.addOrderDetail(o);
            }
            if (!deleteList.isEmpty())
                return this.removeAll(deleteList);
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
    public double getTotal() {
        double sum = 0;
        Iterator<Order> it = this.iterator();
        while (it.hasNext()) {
            Order o = it.next();
            sum += o.getPrice() * o.getQuantity();
        }
        return sum;
    }
    public void displayAll() {
        System.out.printf("%-35s\t%-10s\t%-10s\t%-12s\n", "Product", "Quantity", "Price", "Total cost");
        Iterator<Order> it = this.iterator();
        double sum = 0;
        DecimalFormat df = new DecimalFormat("#");
        while (it.hasNext()) {
            Order o = it.next();
            double total = o.getQuantity()*o.getPrice();
            System.out.printf("%-35s\t%-10s\t%-10s\t%-12s\n", o.getProductName(), o.getQuantity(), df.format(o.getPrice()), df.format(total));
            sum += total;
        }
        System.out.println("Total: " + df.format(sum));
    }
    
}
