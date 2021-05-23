/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Core.Category;
import Validation.MyValidation;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CategoryList extends LinkedList<Category> {
    public boolean addCategory(Category c) {
        try {
            if (c == null || !MyValidation.isID(c.getId()) || !MyValidation.isName(c.getName()) || searchCategory(c.getId()) != null)
                throw new Exception();
            return this.add(c);
        } catch (Exception e) {
            return false;
        }
    }
    
    public Category searchCategory(String id) {
        Iterator<Category> it = iterator();
        while (it.hasNext()) {
            Category nCate = it.next();
            if (nCate.getId().equals(id))
                return nCate;
        }
        return null;
    }
    
    public Category searchCategoryByName(String name) {
        Iterator<Category> it = iterator();
        while (it.hasNext()) {
            Category nCate = it.next();
            if (nCate.getName().equalsIgnoreCase(name))
                return nCate;
        }
        return null;
    }
    
    public boolean updateCategory(Category oldCategory, String newName) {
        try {
            if (oldCategory == null || searchCategory(oldCategory.getId()) == null)
                throw new Exception();
            oldCategory.setName(newName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Category deleteCategory(Category deletedCate, ProductList proList, OrderList orderList) {
        try {
            if (deletedCate == null || searchCategory(deletedCate.getId()) == null)
                throw new Exception();
            if (this.remove(deletedCate)) {
                proList.deleteProduct(deletedCate.getId(), orderList);
                return deletedCate;
            }
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        String result = "";
        Iterator<Category> it = this.iterator();
        while (it.hasNext()) {
            Category ct = it.next();
            result += ct + "\n";
        }
        return result;
    }
    
    
}
