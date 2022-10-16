package com.akademija.webappmvn.shop.cart.model;

import com.akademija.webappmvn.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void AddCartItem(Product product, int quantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == product.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }
        CartItem cartItem = new CartItem(quantity,product);
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
