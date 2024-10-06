package com.example.spock_learning.order;

import static com.example.spock_learning.product.ProductTestFactory.createCleanCodeBook;
import static com.example.spock_learning.product.ProductTestFactory.createMicroservicesBook;

import java.util.List;

public class OrderTestFactory {

    public static Order createBookSetOrder() {
        var cleanCodeOrderLine = new OrderLine(1, createCleanCodeBook());
        var microservicesOrderLine = new OrderLine(1, createMicroservicesBook());

        return new Order(List.of(cleanCodeOrderLine, microservicesOrderLine));
    }
}
