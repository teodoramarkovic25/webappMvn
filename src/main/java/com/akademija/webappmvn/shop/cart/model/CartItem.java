package com.akademija.webappmvn.shop.cart.model;

import com.akademija.webappmvn.shop.model.Product;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Integer quantity;
    private Product product;

    public CartItem() {
    }

    public CartItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public Double getTotalPrice(){
        return  quantity*product.getPrice();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
