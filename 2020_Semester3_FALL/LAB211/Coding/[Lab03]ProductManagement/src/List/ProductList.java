/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Core.Category;
import Core.Product;
import Validation.MyValidation;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class ProductList extends LinkedList<Product>{
    private final CategoryList categoryList;
    
    public ProductList(CategoryList categoryList) {
        this.categoryList = categoryList;
    }
    
    public boolean addProduct(Product p) {
        try {
            if (p == null || !MyValidation.isID(p.getId()) || !MyValidation.isName(p.getName()) ||
                p.getPrice() < 0 || p.getQuantity() < 0 || searchProduct(p.getId()) != null || 
                categoryList.searchCategory(p.getCategoryID()) == null)
                throw new Exception();
            return this.add(p);
        } catch (Exception e) {
            return false;
        }
    }
    
    public Product searchProduct(String id) {
        Iterator<Product> it = iterator();
        while (it.hasNext()) {
            Product sProduct = it.next();
            if (sProduct.getId().equals(id))
                return sProduct;
        }
        return null;
    }
    
    public boolean updateProduct(Product oldProduct, String newName, double newPrice, int newQuantity, String newCateID) {
        try {
            if (oldProduct == null || searchProduct(oldProduct.getId()) == null || !MyValidation.isID(oldProduct.getId()) || !MyValidation.isName(oldProduct.getName()) ||
                oldProduct.getPrice() < 0 || oldProduct.getQuantity() < 0 || 
                categoryList.searchCategory(oldProduct.getCategoryID()) == null)
                throw new Exception();
            oldProduct.setName(newName);
            oldProduct.setPrice(newPrice);
            oldProduct.setQuantity(newQuantity);
            oldProduct.setCategoryID(newCateID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Product deleteProduct(Product deletedPro, OrderList orderList) {
        try {
            if (deletedPro == null || searchProduct(deletedPro.getId()) == null)
                throw new Exception();
            if (this.remove(deletedPro)) {
                orderList.deleteOrderByPro(deletedPro.getName());
                return deletedPro;
            } else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean deleteProduct(String categoryID, OrderList orderList) {
        try {
            if (!MyValidation.isID(categoryID) || searchProduct(categoryID) == null)
                throw new Exception();
            ProductList deleteList = new ProductList(categoryList);
            Iterator<Product> it = this.iterator();
            while (it.hasNext()) {
                Product p = it.next();
                if (p.getCategoryID().equals(categoryID)) {
                    orderList.deleteOrderByPro(p.getName());
                    deleteList.addProduct(p);
                }
            }
            if (!deleteList.isEmpty())
                return this.removeAll(deleteList);
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public ProductList getProductList(String categoryID) {
        ProductList proList = new ProductList(categoryList);
        Iterator<Product> it = this.iterator();
        int i = 0;
        while (it.hasNext()) {
            Product p = it.next();
            if (p.getCategoryID().equals(categoryID)) {
                proList.addProduct(p);
            }
        }
        return proList;
    }
    @Override
    public String toString() {
        String result = "";
        Iterator<Product> it = this.iterator();
        while (it.hasNext()) {
            Product p = it.next();
            result += p + "\n";
        }
        return result;
    }
    
    public ProductList displayAll() {
        System.out.printf("%-5s\t%-35s\t%-10s\t%-10s\n", "No.", "Product name", "Price", "Quantity");
        Iterator<Product> it = this.iterator();
        int i = 0;
        ProductList proList = new ProductList(categoryList);
        while (it.hasNext()) {
            Product p = it.next();
            if (p.getQuantity() > 0) {
                proList.addProduct(p);
                i++;
                DecimalFormat df = new DecimalFormat("#");
                System.out.printf("%-5s\t%-35s\t%-10s\t%-10s\n", i, p.getName(), df.format(p.getPrice()), p.getQuantity());          
            }
        }
        return proList;
    }
    
    public void displayInventory() {
        Iterator<Category> cateIt = categoryList.iterator();
        while (cateIt.hasNext()) {
            Category sCate = cateIt.next();
            String cateName = sCate.getName();
            String cateID = sCate.getId();
            ProductList lPro = getProductList(cateID);
            System.out.println("---------------");
            System.out.println("Category: " + cateName);
            Iterator<Product> it = this.iterator();
            int i = 0;
            while (it.hasNext()) {
                Product p = it.next();
                if (p.getCategoryID().equals(cateID))
                    if (p.getQuantity() >= 0) {
                        i++;
                        DecimalFormat df = new DecimalFormat("#");
                        System.out.printf("%-5s\t%-35s\t%-10s\t%-10s\n", i, p.getName(), df.format(p.getPrice()), p.getQuantity());          
                    }
            }
        }
    }
}
