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
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CartObj implements Serializable {
    private Map<Integer, CartProductDTO> cart;

    public Map<Integer, CartProductDTO> getCart() {
        return cart;
    }

    public void addToCart(int productId, int quantity, float price) {
        // 1. Check existed cart
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        
        // 2. Check existed book
        if (this.cart.containsKey(productId)) {
            quantity = this.cart.get(productId).getQuantity() + quantity;
        }
        
        // 3. Update cart
        this.cart.put(productId, new CartProductDTO(quantity, price));
    }
    
    public void removeFromCart(int productId) {
        // 1. Check existed cart
        if (this.cart == null) {
            return;
        }
        
        // 2. Check existed book
        if (this.cart.containsKey(productId)) {
            this.cart.remove(productId);
            if (this.cart.isEmpty()) {
                this.cart = null;
            }
        }
    }
}
