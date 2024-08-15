package com.doppad.ecommerce.exeption;

public class ProductPurchaseExeption extends RuntimeException{
    public ProductPurchaseExeption(String message) {
        super(message);
    }
}
