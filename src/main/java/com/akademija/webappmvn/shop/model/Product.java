package com.akademija.webappmvn.shop.model;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String productName;
    private Double price;

    public Product(){

    }

    public Product(Integer id, String productName, Double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
