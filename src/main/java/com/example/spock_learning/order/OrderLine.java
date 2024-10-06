package com.example.spock_learning.order;

import com.example.spock_learning.product.Product;
import com.example.spock_learning.shared.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderLine {

    private int amount;
    private Product product;

    public Money getPrice() {
        return product.getPrice().multiply(amount);
    }
}
