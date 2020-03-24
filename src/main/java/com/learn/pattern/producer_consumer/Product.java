package com.learn.pattern.producer_consumer;

public class Product {
    private final String number;

    public Product(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
