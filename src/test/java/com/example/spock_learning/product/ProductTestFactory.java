package com.example.spock_learning.product;

import com.example.spock_learning.shared.Money;
import java.math.BigDecimal;

public class ProductTestFactory {

    public static Product createCleanCodeBook() {
        return new Product("Clean Code: A Handbook of Agile Software Craftsmanship", Money.ofPLN(
            BigDecimal.valueOf(148.28)));
    }

    public static Product createMicroservicesBook() {
        return new Product("Microservices Patterns: With Examples in Java", Money.ofPLN(
            BigDecimal.valueOf(235.40)));
    }
}
