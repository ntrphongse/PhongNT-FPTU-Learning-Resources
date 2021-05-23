/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Core.Product;
import Validation.MyValidation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class OrderList extends HashMap<String, OrderDetail> {
    public boolean addOrder(String customerName, OrderDetail orderDetail) {
        try {
            if (orderDetail == null)
                throw new Exception();
            this.put(customerName, orderDetail);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public OrderDetail searchOrder(String customerName) {
        try {
            if (!MyValidation.isName(customerName))
                throw new Exception();
            if (this.containsKey(customerName)) {
                Set<String> cusName = this.keySet();
                Iterator<String> it = cusName.iterator();
                while (it.hasNext()) {
                    String sName = it.next();
                    if (sName.equals(customerName))
                        return this.get(sName);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public OrderDetail searchOrder(Product product) {
        try {
            if (!MyValidation.isName(product.getName()))
                throw new Exception();
            Set<String> cusName = this.keySet();
            Iterator<String> it = cusName.iterator();
            while (it.hasNext()) {
                String sName = it.next();
                if (sName.equals(product.getName()))
                    return this.get(sName);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean updateOrder(String customerName, OrderDetail order) {
        try {
            if (!MyValidation.isName(customerName) || order == null || searchOrder(customerName) == null)
                throw new Exception();
            return this.replace(customerName, searchOrder(customerName), order);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteOrder(String customerName) {
        try {
            if (!MyValidation.isCustomerName(customerName))
                throw new Exception();
            return (this.remove(customerName) != null);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteOrderByPro(String productName) {
        try {
            if (!MyValidation.isName(productName))
                throw new Exception();
            Set<String> cusName = this.keySet();
            Iterator<String> it = cusName.iterator();
            while (it.hasNext()) {
                String sName = it.next();
                OrderDetail oDetail = this.get(sName);
                oDetail.deleteProductOrder(productName);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void displayAll() {
        Set<String> cusName = this.keySet();
        Iterator<String> it = cusName.iterator();
        while (it.hasNext()) {
            String sName = it.next();
            OrderDetail oDetail = this.get(sName);
            sName = sName.substring(0, sName.length() - 10);
            System.out.println("Customer: " + sName);
            oDetail.displayAll();
            System.out.println("------------------------");
        }
    }
}
