/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Validation.MyValidation;


/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class Category {
    private String id;
    private String name;

    public Category(String id, String name){
        try {
            if (!MyValidation.isID(id))
                throw new Exception("Category ID is invalid. It should contain only 1 - 5 characters a-z, A-Z and 0-9!");
            if (!MyValidation.isName(name))
                throw new Exception("Category name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
            this.id = id;
            this.name = name;
        } catch (Exception ex) {
        }
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (!MyValidation.isName(name))
            throw new Exception("Category name is invalid. It should contain only 2 - 35 characters a-z, A-Z and 0-9!");
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + name;
    }
    
    
}
