/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class CartObj implements Serializable {
    private Map<Integer, Integer> items;

    public Map<Integer, Integer> getItems() {
        return items;
    }
    
    public void addBookToCart(int productId, int quantity) {
        // 1. Check existed cart
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        
        // 2. Check existed book
        if (this.items.containsKey(productId)) {
            quantity = this.items.get(productId) + quantity;
        }
        
        // 3. Update cart
        this.items.put(productId, quantity);
    }
    
    public void removeBookFromCart(int productId) {
        // 1. Check existed cart
        if (this.items == null) {
            return;
        }
        
        // 2. Check existed book
        if (this.items.containsKey(productId)) {
            this.items.remove(productId);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
