package com.example.spock_learning.product;

import com.example.spock_learning.shared.Money;
import lombok.Getter;

@Getter
public class Product {

    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
